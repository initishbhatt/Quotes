package com.quotes.mockdata

import com.quotes.data.model.Quote

/**
 * @author nitishbhatt
 */
object TestData {
    private val quoteDataList = mutableListOf<Quote>()

    fun getQuotesMockData(): List<Quote> {
        quoteDataList.add(
            Quote(
                en = "Computer Science is no more about computers than " +
                    "astronomy is about telescopes.",
                author = "Edsger W. Dijkstra",
                id = "5a6ce86e2af929789500e7e4"
            )
        )
        return quoteDataList
    }
}
