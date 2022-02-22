package com.quotes.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.quotes.R
import com.quotes.data.model.Quote

/**
 * @author nitishbhatt
 */
@Composable
fun QuotesView(quotes: List<Quote>, paddingValues: PaddingValues) {
    LazyColumn(contentPadding = paddingValues) {
        items(quotes) { quote ->
            QuotesBox(quote = quote)
        }
    }
}

@Composable
fun QuotesBox(quote: Quote) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(16.dp)
            .background(MaterialTheme.colors.secondary)
            .padding(16.dp)
    ) {

        Image(
            imageVector = Icons.Default.FormatQuote,
            contentDescription =
            stringResource(R.string.quote)
        )

        Text(text = quote.en)

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.CenterEnd
        ) {
            Image(
                imageVector = Icons.Default.FormatQuote,
                contentDescription = "Quote"
            )
        }

        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = quote.author,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
    }
}
