package com.quotes.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.quotes.R
import com.quotes.data.model.Quote
import com.quotes.ui.quotes.QuotesViewModel
import com.quotes.utils.share

@Composable
fun QuoteBox(viewModel: QuotesViewModel, quote: Quote) {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.secondary)
                .padding(32.dp)
                .align(Alignment.Center)
                .padding(16.dp)
        ) {

            Image(
                imageVector = Icons.Default.FormatQuote,
                contentDescription = stringResource(R.string.quote)
            )

            Text(text = quote.en)

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Image(
                    imageVector = Icons.Default.FormatQuote,
                    contentDescription = stringResource(R.string.quote)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = quote.author,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Box(modifier = Modifier.fillMaxSize()) {
                Row(modifier = Modifier.align(Alignment.Center)) {
                    ShareCta { context.share(quote.en.plus(" ").plus("- ${quote.author}")) }

                    Spacer(modifier = Modifier.width(32.dp))

                    RefreshCta { viewModel.getRandomQuote() }

                    Spacer(modifier = Modifier.width(32.dp))

                    FavouriteCta { viewModel.addQuote(quote) }
                }
            }
        }
    }
}
