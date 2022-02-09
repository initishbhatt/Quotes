package com.quotes.ui.quotedetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.quotes.data.model.Quotes

/**
 * @author nitishbhatt
 */
@Composable
fun QuoteDetailScreen(quotes: Quotes, popBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("") },
                navigationIcon = {
                    IconButton(onClick = { popBack() }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                })
        }) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colors.secondary)
                    .padding(32.dp)
                    .align(Alignment.Center)
                    .padding(16.dp)
            ) {

                Image(imageVector = Icons.Default.FormatQuote, contentDescription = "Quote")

                Text(text = quotes.en)

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
                        text = quotes.author,
                        modifier = Modifier.align(Alignment.CenterEnd)
                    )
                }
            }
        }
    }
}