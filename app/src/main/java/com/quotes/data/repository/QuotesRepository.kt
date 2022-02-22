package com.quotes.data.repository

import com.quotes.data.model.Quote
import com.quotes.utils.Result

/**
 * @author nitishbhatt
 */
interface QuotesRepository {
    suspend fun getRandomQuote(): Result<Quote, Exception>
}
