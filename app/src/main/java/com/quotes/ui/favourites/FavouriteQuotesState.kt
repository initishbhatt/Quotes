package com.quotes.ui.favourites

import com.quotes.data.model.Quote

sealed class FavouriteQuotesState {
    object Empty : FavouriteQuotesState()
    object Loading : FavouriteQuotesState()
    data class Error(val message: Exception) : FavouriteQuotesState()
    data class Success(val quotes: List<Quote>) : FavouriteQuotesState()
}
