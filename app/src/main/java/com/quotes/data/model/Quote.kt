package com.quotes.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

/**
 * @author nitishbhatt
 */
@Entity(tableName = "favourites")
@Serializable
data class Quote(
    val author: String,
    val en: String,
    @PrimaryKey
    val id: String
)
