package com.quotes.data.repository

import com.quotes.data.model.Quotes
import com.quotes.utils.Result
import java.lang.Exception

/**
 * @author nitishbhatt
 */
interface QuotesRepository {
    suspend fun getAllQuotes(): Result<List<Quotes>, Exception>
}
