package com.quotes.data.repository

import com.quotes.data.model.Quote
import kotlinx.coroutines.flow.Flow

interface FavouriteQuoteRepository {
    suspend fun addFavouriteQuote(quote: Quote)

    suspend fun deleteFavouriteQuote(quote: Quote)

    fun getAllFavouriteQuotes(): Flow<List<Quote>>
}
