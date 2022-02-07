package com.quotes.data.repository

import com.quotes.data.model.Quotes

/**
 * @author nitishbhatt
 */
interface QuotesRepository {
    suspend fun getAllQuotes(): Result<List<Quotes>>
}
