package com.quotes.data.repository

import com.quotes.data.db.FavouritesDao
import com.quotes.data.model.Quote
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class FavouriteQuotesRepository @Inject constructor(private val favouritesDao: FavouritesDao) {
    suspend fun addFavouriteQuote(quote: Quote) = favouritesDao.addFavouriteQuote(quote)

    suspend fun deleteFavouriteQuote(quote: Quote) =
        favouritesDao.deleteFavouriteQuote(quote)

    fun getAllFavouriteQuotes(): Flow<List<Quote>> = favouritesDao.getFavouriteQuotesList()
}
