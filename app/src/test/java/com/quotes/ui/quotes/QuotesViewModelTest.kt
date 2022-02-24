package com.quotes.ui.quotes

import app.cash.turbine.test
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.quotes.MainCoroutineRule
import com.quotes.data.repository.FavouriteQuoteRepository
import com.quotes.data.repository.QuotesRepository
import com.quotes.mockdata.TestData
import com.quotes.utils.Failure
import com.quotes.utils.Success
import kotlin.test.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class QuotesViewModelTest {
    @get:Rule
    var coroutineRule = MainCoroutineRule()

    private val repository: QuotesRepository = mock()
    private val favouriteQuotesRepository: FavouriteQuoteRepository = mock()

    private val viewModel =
        QuotesViewModel(repository, favouriteQuotesRepository, coroutineRule.testDispatcherProvider)

    @Test
    fun `should get random quote when initialized`() = runTest {
        whenever(repository.getRandomQuote()).thenReturn(
            Success(
                TestData.getQuotesMockData().first()
            )
        )

        viewModel.quote.test {
            assertEquals(awaitItem()::class, QuoteState.Loading::class)
            assertEquals(awaitItem()::class, QuoteState.Success::class)
            cancelAndConsumeRemainingEvents()
        }
    }

    @Test
    fun `should get error when fetching random quote fails`() = runTest {
        whenever(repository.getRandomQuote()).thenReturn(Failure(IllegalStateException()))

        viewModel.quote.test {
            assertEquals(awaitItem()::class, QuoteState.Loading::class)
            assertEquals(awaitItem()::class, QuoteState.Error::class)
            cancelAndConsumeRemainingEvents()
        }
    }
}
