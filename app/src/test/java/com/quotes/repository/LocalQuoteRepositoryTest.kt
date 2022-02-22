package com.quotes.repository

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.quotes.MainCoroutineRule
import com.quotes.data.repository.AssetManagerUseCase
import com.quotes.data.repository.LocalQuotesRepository
import com.quotes.mockdata.TestData
import com.quotes.utils.Failure
import com.quotes.utils.Success
import kotlin.test.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

/**
 * @author nitishbhatt
 */
@ExperimentalCoroutinesApi
class LocalQuoteRepositoryTest {
    @get:Rule
    var coroutineRule = MainCoroutineRule()

    private val assetManagerUseCase: AssetManagerUseCase = mock()

    private val repository = LocalQuotesRepository(assetManagerUseCase)

    @Test
    fun `should return list of cities from assets when invoked`() = runTest {
        whenever(assetManagerUseCase.fetchQuotesList("quotes.json"))
            .thenReturn(TestData.getQuotesMockData())
        val expected = TestData.getQuotesMockData()

        val result = repository.getRandomQuote()

        assertEquals(Success(expected).value, (result as Success).value)
    }

    @Test
    fun `should return error when fetching cities data fails`() = runTest {
        val exception = Exception("error")
        whenever(assetManagerUseCase.fetchQuotesList("quotes.json"))
            .thenAnswer {
                throw exception
            }

        val result = repository.getRandomQuote()

        assertEquals(exception.message, (result as Failure).reason.message)
    }
}
