package com.quotes.ui.favourites

import app.cash.turbine.test
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.quotes.MainCoroutineRule
import com.quotes.data.repository.FavouriteQuoteRepository
import com.quotes.mockdata.TestData
import kotlin.test.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class FavouritesViewModelTest {

    @get:Rule
    var coroutineRule = MainCoroutineRule()

    private val repository: FavouriteQuoteRepository = mock()

    private val viewModel = FavouritesViewModel(repository, coroutineRule.testDispatcherProvider)

    @Test
    fun `should fetch all favourite quotes when initialized`() = runTest {
        whenever(repository.getAllFavouriteQuotes())
            .thenReturn(flowOf(TestData.getQuotesMockData()))

        viewModel.favQuote.test {
            assertEquals(awaitItem()::class, FavouriteQuotesState.Loading::class)
            assertEquals(awaitItem()::class, FavouriteQuotesState.Success::class)
            cancelAndConsumeRemainingEvents()
        }
    }

    @Test
    fun `should show empty state when no favourite quotes are available`() = runTest {
        whenever(repository.getAllFavouriteQuotes()).thenReturn(flowOf(emptyList()))

        viewModel.favQuote.test {
            assertEquals(awaitItem()::class, FavouriteQuotesState.Loading::class)
            assertEquals(awaitItem()::class, FavouriteQuotesState.Empty::class)
            cancelAndConsumeRemainingEvents()
        }
    }
}
