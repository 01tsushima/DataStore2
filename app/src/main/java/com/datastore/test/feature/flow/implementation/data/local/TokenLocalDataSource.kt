package com.datastore.test.feature.flow.implementation.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.datastore.test.PreferenceKeys
import com.datastore.test.core.put

class TokenLocalDataSource(private val dataStore: DataStore<Preferences>) {

    suspend fun saveToken(string: String) {
        dataStore.put(PreferenceKeys.Token.FIELD_TOKEN, string)
    }
}