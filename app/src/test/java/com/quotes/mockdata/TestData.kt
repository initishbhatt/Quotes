package com.quotes.mockdata

import com.quotes.data.model.Quotes

/**
 * @author nitishbhatt
 */
object TestData {
    private val quotesDataList = mutableListOf<Quotes>()

    fun getQuotesMockData(): List<Quotes> {
        quotesDataList.add(
            Quotes(
                en = "Computer Science is no more about computers than " +
                    "astronomy is about telescopes.",
                author = "Edsger W. Dijkstra",
                id = "5a6ce86e2af929789500e7e4"
            )
        )
        quotesDataList.add(
            Quotes(
                id = "5a6ce86e2af929789500e7d7",
                author = "Edsger W. Dijkstra",
                en = "Simplicity is prerequisite for reliability."
            )
        )
        return quotesDataList
    }
}
