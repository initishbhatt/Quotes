package com.quotes.data.repository

import com.quotes.data.db.FavouritesDao
import com.quotes.data.model.Quote
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class FavouriteQuotesRepositoryImpl @Inject constructor(private val favouritesDao: FavouritesDao) :
    FavouriteQuoteRepository {
    override suspend fun addFavouriteQuote(quote: Quote) = favouritesDao.addFavouriteQuote(quote)

    override suspend fun deleteFavouriteQuote(quote: Quote) =
        favouritesDao.deleteFavouriteQuote(quote)

    override fun getAllFavouriteQuotes(): Flow<List<Quote>> = favouritesDao.getFavouriteQuotesList()
}
