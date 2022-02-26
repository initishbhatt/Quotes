package com.quotes.di

import android.content.Context
import android.content.res.AssetManager
import androidx.room.Room
import com.quotes.data.db.FavouritesDao
import com.quotes.data.db.QuotesDatabase
import com.quotes.data.preference.QuotesPreferenceStore
import com.quotes.utils.DefaultDispatcherProvider
import com.quotes.utils.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.serialization.json.Json

/**
 * @author nitishbhatt
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideAssetManager(@ApplicationContext context: Context): AssetManager = context.assets

    @Provides
    fun provideJsonSerialization(): Json = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
        isLenient = false
    }

    @Provides
    fun provideDispatcher(dispatcherProvider: DefaultDispatcherProvider): DispatcherProvider =
        dispatcherProvider

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): QuotesDatabase =
        Room.databaseBuilder(
            context,
            QuotesDatabase::class.java,
            "favourites-quote-db"
        ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideFavouritesDao(database: QuotesDatabase): FavouritesDao = database.getFavouritesDao()

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context): QuotesPreferenceStore =
        QuotesPreferenceStore(context)
}
