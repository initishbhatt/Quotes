package com.quotes.ui.quotes

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.quotes.ui.components.ProgressIndicator
import com.quotes.ui.components.QuoteBox
import com.quotes.ui.components.visible

/**
 * @author nitishbhatt
 */
@Composable
fun QuoteScreen(viewModel: QuotesViewModel) {

    val quoteState by viewModel.quote.collectAsState()

    when (quoteState) {
        is QuoteState.Loading -> ProgressIndicator(modifier = Modifier.visible(true))
        is QuoteState.Success -> {
            Scaffold(
                topBar = {
                    TopAppBar(title = { Text("Quotes") })
                }
            ) {
                QuoteBox(viewModel = viewModel, quote = (quoteState as QuoteState.Success).quote)
            }
        }
        is QuoteState.Error -> ProgressIndicator(modifier = Modifier.visible(false))
    }
}
