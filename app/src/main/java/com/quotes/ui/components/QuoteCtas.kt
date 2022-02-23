package com.quotes.ui.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Share
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
fun QuoteCtas(viewModel: QuotesViewModel, quote: Quote) {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.align(Alignment.Center)) {
            QuoteButton(
                icon = Icons.Default.Refresh,
                contentDescription = stringResource(R.string.refresh),
                modifier = Modifier.clickable {
                    viewModel.getRandomQuote()
                }
            )

            Spacer(modifier = Modifier.width(30.dp))

            QuoteButton(
                icon = Icons.Default.Share,
                contentDescription = stringResource(R.string.share),
                modifier = Modifier.clickable {
                    context.share(quote.en.plus(" ").plus("- ${quote.author}"))
                }
            )

            Spacer(modifier = Modifier.width(30.dp))

            QuoteButton(
                icon = Icons.Default.Favorite,
                contentDescription = stringResource(R.string.favourites),
                modifier = Modifier.clickable {
                    viewModel.addQuote(quote)
                    Toast.makeText(context, "Added to Favourites", Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}
