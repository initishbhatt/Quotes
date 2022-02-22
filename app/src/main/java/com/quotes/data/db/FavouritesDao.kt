package com.quotes.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.quotes.data.model.Quote
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouritesDao {
    @Query("SELECT * FROM favourites")
    fun getFavouriteQuotesList(): Flow<List<Quote>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavouriteQuote(quote: Quote)

    @Delete
    suspend fun deleteFavouriteQuote(quote: Quote)
}
