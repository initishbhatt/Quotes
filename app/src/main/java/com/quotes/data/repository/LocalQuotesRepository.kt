package com.quotes.data.repository

import com.quotes.data.model.Quotes
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
    override suspend fun getAllQuotes(): Result<List<Quotes>> {
        return try {
            val result = assetManagerUseCase.fetchQuotesList(FILE_NAME)
            Timber.d(
                "Success fetching quotes from assets" +
                    " with total quotes count: ${result.count()}"
            )
            Result.success(result)
        } catch (ex: Exception) {
            Timber.d(ex, "Unable to fetch quotes: ${ex.localizedMessage}")
            Result.failure(Exception(ex.message))
        }
    }
}
