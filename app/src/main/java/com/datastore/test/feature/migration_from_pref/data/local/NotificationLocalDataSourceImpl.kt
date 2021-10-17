package com.datastore.test.feature.migration_from_pref.data.local

import android.content.SharedPreferences
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.datastore.test.PreferenceKeys
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NotificationLocalDataSourceImpl
@Inject constructor(
    private val preferences: SharedPreferences,
    private val dataStore: DataStore<Preferences>
) : NotificationLocalDataSource {

    override fun getSubscribeNotification(): Flow<Boolean> = dataStore.data.map {
        it[PreferenceKeys.Notification.FIELD_NOTIFICATION] ?: false
    }

    override suspend fun setNotification(subscribe: Boolean) {
        dataStore.edit {
            it[PreferenceKeys.Notification.FIELD_NOTIFICATION] = subscribe
        }
    }

    override suspend fun setNotificationFromShared(subscribe: Boolean) {
        preferences.edit().putBoolean(
            PreferenceKeys.NotificationInSharedPreferences.NOTIFICATION,
            subscribe
        ).apply()
    }
}