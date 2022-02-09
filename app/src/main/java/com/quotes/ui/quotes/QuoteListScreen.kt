package com.quotes.ui.quotes

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.quotes.data.model.Quotes
import com.quotes.ui.components.ProgressIndicator
import com.quotes.ui.components.QuotesView
import com.quotes.ui.components.visible
import com.quotes.ui.main.MainState
import com.quotes.ui.main.MainViewModel

/**
 * @author nitishbhatt
 */
@Composable
fun QuoteListScreen(
    paddingValues: PaddingValues = PaddingValues(),
    quoteSelected: (Quotes) -> Unit,
    viewModel: MainViewModel
) {
    val quotesListState by viewModel.quotesList.collectAsState()

    when (quotesListState) {
        is MainState.Loading -> ProgressIndicator(modifier = Modifier.visible(true))
        is MainState.Success -> {
            Scaffold(
                topBar = {
                    TopAppBar(title = { Text("Quotes") })
                }) {
                QuotesView(
                    quotes = (quotesListState as MainState.Success).quotes,
                    paddingValues = paddingValues,
                    onClick = quoteSelected
                )
            }
        }
        is MainState.Error -> ProgressIndicator(modifier = Modifier.visible(false))
    }
}