package com.datastore.test.di.application

import android.content.Context
import android.content.SharedPreferences
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.rxjava2.RxDataStore

/** `AppComponent` dependencies provided to the underlying components and scopes. */
interface ApplicationComponentProxy {

    fun context(): Context

    fun dataStorePref(): RxDataStore<Preferences>
    fun dataStore(): DataStore<Preferences>
    fun preferences(): SharedPreferences
}