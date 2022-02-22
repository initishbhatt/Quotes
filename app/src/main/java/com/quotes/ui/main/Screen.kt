package com.quotes.ui.main

/**
 * @author nitishbhatt
 */
sealed class Screen(val title: String) {
    object Quote : Screen("Quote")
    object FavouriteQuotes : Screen("FavouriteQuotes")
}
