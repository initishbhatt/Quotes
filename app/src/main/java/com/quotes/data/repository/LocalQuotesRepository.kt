package com.quotes.data.repository

import com.quotes.data.model.Quotes
import com.quotes.utils.Failure
import com.quotes.utils.Result
import com.quotes.utils.Success
import timber.log.Timber
import javax.inject.Inject

/**
 * @author nitishbhatt
 */
const val FILE_NAME = "quotes.json"

class LocalQuotesRepository @Inject constructor(
    private val assetManagerUseCase: AssetManagerUseCase
) :
    QuotesRepository {
    override suspend fun getAllQuotes(): Result<List<Quotes>, Exception> {
        return try {
            val result = assetManagerUseCase.fetchQuotesList(FILE_NAME)
            Timber.d(
                "Success fetching quotes from assets" +
                        " with total quotes count: ${result.count()}"
            )
            Success(result)
        } catch (ex: Exception) {
            Timber.d(ex, "Unable to fetch quotes: ${ex.localizedMessage}")
            Failure(Exception(ex.message))
        }
    }
}
