package com.quotes.ui.main

import com.quotes.data.model.Quotes

/**
 * @author nitishbhatt
 */
sealed class MainState {
    object Loading : MainState()
    data class Error(val message: Exception) : MainState()
    data class Success(val quotes: List<Quotes>) : MainState()
}