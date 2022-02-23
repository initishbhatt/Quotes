package com.quotes.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.quotes.data.model.Quote

@Database(entities = [Quote::class], version = 1, exportSchema = false)
abstract class QuotesDatabase : RoomDatabase() {
    abstract fun getFavouritesDao(): FavouritesDao
}
