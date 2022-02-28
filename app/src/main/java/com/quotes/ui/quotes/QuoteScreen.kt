package com.quotes.ui.quotes

import androidx.compose.foundation.clickable
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FlashlightOff
import androidx.compose.material.icons.filled.FlashlightOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.quotes.ui.components.ProgressIndicator
import com.quotes.ui.components.QuoteBox
import com.quotes.ui.components.QuotesErrorScreen
import com.quotes.ui.components.visible

/**
 * @author nitishbhatt
 */
@Composable
fun QuoteScreen(viewModel: QuotesViewModel, toggleTheme: () -> Unit, darkTheme: Boolean) {

    when (val quoteState = viewModel.quote.collectAsState().value) {
        is QuoteState.Loading -> ProgressIndicator(modifier = Modifier.visible(true))
        is QuoteState.Success -> {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("Quotes") },
                        actions = {
                            val icon =
                                if (darkTheme) Icons.Default.FlashlightOff else Icons.Default.FlashlightOn
                            Icon(
                                imageVector = icon,
                                contentDescription = "Toggle",
                                modifier = Modifier.clickable {
                                    toggleTheme()
                                }
                            )
                        }
                    )
                }
            ) {
                QuoteBox(viewModel = viewModel, quote = quoteState.quote)
            }
        }
        is QuoteState.Error -> QuotesErrorScreen() { viewModel.getRandomQuote() }
    }
}
