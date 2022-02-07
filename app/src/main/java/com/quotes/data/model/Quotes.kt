package com.quotes.data.model

import kotlinx.serialization.Serializable

/**
 * @author nitishbhatt
 */
@Serializable
data class Quotes(
    val author: String,
    val en: String,
    val id: String
)
