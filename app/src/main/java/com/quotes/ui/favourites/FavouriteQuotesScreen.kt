package com.quotes.ui.favourites

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import com.quotes.R
import com.quotes.ui.components.FavouritesEmptyScreen
import com.quotes.ui.components.FavouritesErrorScreen
import com.quotes.ui.components.ProgressIndicator
import com.quotes.ui.components.QuotesView
import com.quotes.ui.components.visible

/**
 * @author nitishbhatt
 */
@Composable
fun FavouriteQuotesScreen(viewModel: FavouritesViewModel, paddingValues: PaddingValues) {

    when (val favouriteQuoteState = viewModel.favQuote.collectAsState().value) {
        is FavouriteQuotesState.Loading -> ProgressIndicator(
            modifier =
            Modifier.visible(true)
        )
        is FavouriteQuotesState.Empty -> FavouritesEmptyScreen()
        is FavouriteQuotesState.Success -> {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(stringResource(R.string.favourites)) },
                        modifier = Modifier.testTag("Fav")
                    )
                }
            ) {
                QuotesView(
                    quotes = favouriteQuoteState.quotes,
                    paddingValues = paddingValues,
                    onDismiss = { viewModel.deleteQuote(it) }
                )
            }
        }
        is FavouriteQuotesState.Error -> FavouritesErrorScreen { viewModel.getAllFavouriteQuotes() }
    }
}
