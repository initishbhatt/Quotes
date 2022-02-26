package com.quotes.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
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
import androidx.compose.material.Card
import androidx.compose.material.DismissDirection.EndToStart
import androidx.compose.material.DismissValue.Default
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.quotes.R
import com.quotes.data.model.Quote
import com.quotes.ui.theme.AppTypography

/**
 * @author nitishbhatt
 */
@Composable
fun QuotesView(
    quotes: List<Quote>,
    paddingValues: PaddingValues,
    onDismiss: (quote: Quote) -> Unit
) {
    LazyColumn(contentPadding = paddingValues) {
        items(quotes, { quoteList -> quoteList.id }) { quote ->
            val dismissState = rememberDismissState()
            if (dismissState.isDismissed(EndToStart)) {
                onDismiss(quote)
            }
            SwipeToDismiss(
                state = dismissState,
                modifier = Modifier.padding(vertical = 4.dp),
                directions = setOf(EndToStart),
                dismissThresholds = { FractionalThreshold(0.25f) },
                background = {
                    val color by animateColorAsState(
                        when (dismissState.targetValue) {
                            Default -> MaterialTheme.colors.background
                            else -> MaterialTheme.colors.error
                        }
                    )
                    val alignment = Alignment.CenterEnd
                    val icon = Icons.Default.Delete
                    val scale by animateFloatAsState(
                        if (dismissState.targetValue == Default) 0.75f else 1f
                    )
                    Box(
                        Modifier
                            .fillMaxSize()
                            .background(color)
                            .padding(horizontal = 20.dp),
                        contentAlignment = alignment
                    ) {
                        Icon(
                            icon,
                            contentDescription = stringResource(R.string.swipe_to_delete),
                            modifier = Modifier
                                .scale(scale),
                            tint = Color.White
                        )
                    }
                },
                dismissContent = {
                    ListItem(text = { QuotesBox(quote = quote) })
                }
            )
        }
    }
}

@Composable
fun QuotesBox(quote: Quote) {
    Card(
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 4.dp,
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(8.dp)
        ) {

            Image(
                imageVector = Icons.Default.FormatQuote,
                contentDescription =
                stringResource(R.string.quote)
            )

            Text(
                text = quote.en,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Justify,
                style = AppTypography.subtitle2
            )

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
                    text = "- ${quote.author}",
                    modifier = Modifier.align(Alignment.CenterEnd),
                    style = AppTypography.caption
                )
            }
        }
    }
}
