package com.quotes.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.quotes.R

@Composable
fun RefreshCta(onRefreshButtonClick: () -> Unit) {
    IconButton(onClick = { onRefreshButtonClick() }) {
        Icon(
            imageVector = Icons.Default.Refresh,
            contentDescription = stringResource(R.string.refresh),
            modifier = Modifier.padding(16.dp)
        )
    }
}
