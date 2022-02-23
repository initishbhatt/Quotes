package com.quotes.data.repository

import com.quotes.data.model.Quote
import com.quotes.utils.Failure
import com.quotes.utils.Result
import com.quotes.utils.Success
import javax.inject.Inject
import timber.log.Timber

/**
 * @author nitishbhatt
 */
const val FILE_NAME = "quotes.json"

class LocalQuotesRepository @Inject constructor(
    private val assetManagerUseCase: AssetManagerUseCase
) :
    QuotesRepository {
    override suspend fun getRandomQuote(): Result<Quote, Exception> {
        return try {
            val result = assetManagerUseCase.fetchQuotesList(FILE_NAME).random()
            Timber.d(
                "Success fetching quotes from assets" +
                    " with quote id: ${result.id}"
            )
            Success(result)
        } catch (ex: Exception) {
            Timber.d(ex, "Unable to fetch quote: ${ex.localizedMessage}")
            Failure(Exception(ex.message))
        }
    }
}
