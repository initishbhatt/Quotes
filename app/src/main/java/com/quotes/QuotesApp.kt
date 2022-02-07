package com.quotes

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * @author nitishbhatt
 */
@HiltAndroidApp
class QuotesApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.d("TimberInitializer is initialized.")
    }
}
