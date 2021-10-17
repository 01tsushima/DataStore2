package com.datastore.test.feature.flow.implementation.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import com.datastore.test.PreferenceKeys
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class TokenLocalDataSourceImpl @Inject constructor(private val dataStore: DataStore<Preferences>) :
    TokenLocalDataSource {

    override fun token() = dataStore.data.catch { exception ->
        if (exception is IOException) {
            emit(emptyPreferences())
        } else {
            throw exception
        }
    }.map {
        it[PreferenceKeys.Token.FIELD_TOKEN] ?: ""
    }

    override suspend fun saveToken(string: String) {
        dataStore.edit {
            it[PreferenceKeys.Token.FIELD_TOKEN] = string
        }
    }
}