package com.quotes.repository

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.quotes.MainCoroutineRule
import com.quotes.data.repository.AssetManagerUseCase
import com.quotes.data.repository.LocalQuotesRepository
import com.quotes.mockdata.TestData
import kotlin.test.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

/**
 * @author nitishbhatt
 */
@ExperimentalCoroutinesApi
class LocalQuotesRepositoryTest {
    @get:Rule
    var coroutineRule = MainCoroutineRule()

    private val assetManagerUseCase: AssetManagerUseCase = mock()

    private val repository = LocalQuotesRepository(assetManagerUseCase)

    @Test
    fun `should return list of cities from assets when invoked`() = runTest {
        whenever(assetManagerUseCase.fetchQuotesList("quotes.json"))
            .thenReturn(TestData.getQuotesMockData())
        val expected = TestData.getQuotesMockData()
        val result = repository.getAllQuotes()

        assertEquals(Result.success(expected).getOrNull(), result.getOrNull())
    }

    @Test
    fun `should return error when fetching cities data fails`() = runTest {
        val exception = Exception("error")
        whenever(assetManagerUseCase.fetchQuotesList("quotes.json"))
            .thenAnswer {
                throw exception
            }

        val result = repository.getAllQuotes()

        assertEquals(exception.message, result.exceptionOrNull()?.message)
    }
}
