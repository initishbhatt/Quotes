package com.quotes.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quotes.data.model.Quote
import com.quotes.data.repository.FavouriteQuoteRepository
import com.quotes.data.repository.QuotesRepository
import com.quotes.utils.DispatcherProvider
import com.quotes.utils.Failure
import com.quotes.utils.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

@HiltViewModel
class QuotesViewModel @Inject constructor(
    private val repository: QuotesRepository,
    private val favouriteQuotesRepository: FavouriteQuoteRepository,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {
    private var _quote = MutableStateFlow<QuoteState>(QuoteState.Loading)

    val quote: StateFlow<QuoteState> = _quote.asStateFlow()

    init {
        getRandomQuote()
    }

    fun getRandomQuote() {
        viewModelScope.launch(dispatcherProvider.io()) {
            when (val randomQuote = repository.getRandomQuote()) {
                is Success -> {
                    Timber.d("Fetch success")
                    _quote.value = QuoteState.Success(randomQuote.value)
                }
                is Failure -> {
                    _quote.value = QuoteState.Error(randomQuote.reason)
                }
            }
        }
    }

    fun addQuote(quote: Quote) {
        viewModelScope.launch(dispatcherProvider.io()) {
            favouriteQuotesRepository.addFavouriteQuote(quote)
        }
    }
}
