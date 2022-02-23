package com.quotes.ui.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * @author nitishbhatt
 */
data class BottomNavigationItem(val route: String, val icon: ImageVector, val title: String)

val bottomNavigationItems = listOf(
    BottomNavigationItem(
        Screen.Quote.title,
        Icons.Default.FormatQuote, "Quote"
    ),
    BottomNavigationItem(
        Screen.FavouriteQuotes.title,
        Icons.Default.Favorite, "Favourites"
    )
)
