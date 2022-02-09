package com.quotes.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quotes.data.repository.QuotesRepository
import com.quotes.utils.DispatcherProvider
import com.quotes.utils.Failure
import com.quotes.utils.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * @author nitishbhatt
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: QuotesRepository,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {
    private var _quotesList = MutableStateFlow<MainState>(MainState.Loading)

    val quotesList: StateFlow<MainState> = _quotesList

    init {
        viewModelScope.launch(dispatcherProvider.io()) {
            when (val quotesList = repository.getAllQuotes()) {
                is Success -> {
                    Timber.d("Fetch success")
                    _quotesList.value = MainState.Success(quotesList.value)
                }
                is Failure -> {
                    _quotesList.value = MainState.Error(quotesList.reason)
                }
            }
        }
    }
}