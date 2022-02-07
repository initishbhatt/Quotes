package com.quotes.di

import com.quotes.data.repository.LocalQuotesRepository
import com.quotes.data.repository.QuotesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author nitishbhatt
 */
@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun provideQuotesRepository(repository: LocalQuotesRepository): QuotesRepository
}
