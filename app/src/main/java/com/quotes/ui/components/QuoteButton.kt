package com.quotes.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun QuoteButton(icon: ImageVector, contentDescription: String, modifier: Modifier) {
    Icon(
        imageVector = icon,
        contentDescription = contentDescription,
        modifier = modifier.padding(16.dp)
    )
}
