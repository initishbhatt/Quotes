package com.quotes.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.quotes.R
import com.quotes.data.model.Quote
import com.quotes.ui.quotes.QuotesViewModel
import com.quotes.ui.theme.appTypography
import com.quotes.utils.share

@Composable
fun QuoteBox(viewModel: QuotesViewModel, quote: Quote) {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        Card(
            backgroundColor = MaterialTheme.colors.secondary,
            elevation = 4.dp,
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .padding(4.dp)
                .align(Alignment.TopCenter)
                .padding(16.dp)
        ) {
            Column(modifier = Modifier.padding(8.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    ShareCta { context.share(quote.en.plus(" ").plus("- ${quote.author}")) }
                    FavouriteCta { viewModel.addQuote(quote) }
                }
                Image(
                    imageVector = Icons.Default.FormatQuote,
                    contentDescription = stringResource(R.string.quote)
                )
                Text(
                    text = quote.en,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .wrapContentSize(align = Alignment.Center),
                    style = appTypography.h5,
                    textAlign = TextAlign.Center
                )

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
                        modifier = Modifier.align(Alignment.CenterEnd),
                        textAlign = TextAlign.Center,
                        style = appTypography.subtitle2
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 80.dp),
            contentAlignment = Alignment.Center
        ) {

            RefreshCta { viewModel.getRandomQuote() }

        }
    }
}

