package com.quotes.di

import android.content.Context
import android.content.res.AssetManager
import com.quotes.utils.DefaultDispatcherProvider
import com.quotes.utils.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
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
}
