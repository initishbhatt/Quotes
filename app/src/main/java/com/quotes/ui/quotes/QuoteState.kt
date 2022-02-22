package com.quotes.ui.quotes

import com.quotes.data.model.Quote

/**
 * @author nitishbhatt
 */
sealed class QuoteState {
    object Loading : QuoteState()
    data class Error(val message: Exception) : QuoteState()
    data class Success(val quote: Quote) : QuoteState()
}
