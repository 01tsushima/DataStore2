package com.datastore.test.di

import android.content.Context
import android.content.SharedPreferences
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.rxjava2.RxPreferenceDataStoreBuilder
import androidx.datastore.rxjava2.RxDataStore
import com.datastore.test.di.scope.PerApplication
import com.datastore.test.util.dataStore

import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    @PerApplication
    fun provideRxPreferences(context: Context): RxDataStore<Preferences> {
        return RxPreferenceDataStoreBuilder(context.applicationContext, "dataStoreAppRx").build()
    }

    @Provides
    @PerApplication
    fun provideDataStoreManager(context: Context): DataStore<Preferences> {
        return context.applicationContext.dataStore
    }

    @Provides
    @PerApplication
    fun provideSharedPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences("NO_BACKUP_SHARED_PREF", Context.MODE_PRIVATE)
    }
}