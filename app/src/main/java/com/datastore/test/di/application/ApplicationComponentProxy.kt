package com.datastore.test.di.application

import android.content.Context
import android.content.SharedPreferences
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.rxjava2.RxDataStore
import com.datastore.test.UserPreference
import com.datastore.test.feature.proto.data.local.UserPreferencesSerializer
import com.google.crypto.tink.Aead

/** `AppComponent` dependencies provided to the underlying components and scopes. */
interface ApplicationComponentProxy {

    fun context(): Context

    fun dataStorePref(): RxDataStore<Preferences>
    fun dataStore(): DataStore<Preferences>
    fun preferences(): SharedPreferences
    fun protoDataStore(): DataStore<UserPreference>
    fun aead(): Aead
    fun serializer(): UserPreferencesSerializer
}