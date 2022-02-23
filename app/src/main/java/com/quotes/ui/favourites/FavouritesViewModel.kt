package com.quotes.ui.favourites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quotes.data.model.Quote
import com.quotes.data.repository.FavouriteQuotesRepository
import com.quotes.utils.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@HiltViewModel
class FavouritesViewModel @Inject constructor(
    private val repository: FavouriteQuotesRepository,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private var _favQuote = MutableStateFlow<FavouriteQuotesState>(FavouriteQuotesState.Loading)

    val favQuote: StateFlow<FavouriteQuotesState> = _favQuote

    init {
        getAllFavouriteQuotes()
    }

    fun getAllFavouriteQuotes() {
        viewModelScope.launch(dispatcherProvider.io()) {
            repository.getAllFavouriteQuotes().distinctUntilChanged().collectLatest { quotes ->
                if (quotes.isEmpty()) {
                    _favQuote.value = FavouriteQuotesState.Empty
                } else {
                    _favQuote.value = FavouriteQuotesState.Success(quotes)
                }
            }
        }
    }

    fun deleteQuote(quote: Quote) {
        viewModelScope.launch(dispatcherProvider.io()) {
            repository.deleteFavouriteQuote(quote)
        }
    }
}
