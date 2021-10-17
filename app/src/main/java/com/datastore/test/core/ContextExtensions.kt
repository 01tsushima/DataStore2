package com.datastore.test.core

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

val Context.dataStore: DataStore<Preferences>
by preferencesDataStore(
    name = "dataStoreApp",
    scope = CoroutineScope(Dispatchers.IO))