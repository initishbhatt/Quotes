package com.quotes.ui.main

/**
 * @author nitishbhatt
 */
sealed class Screen(val title: String) {
    object QuotesList : Screen("QuotesList")
    object QuoteDetails : Screen("QuoteDetails")
    object FavouriteQuotes : Screen("FavouriteQuotes")
}