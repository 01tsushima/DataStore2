package com.datastore.test.feature.migration_from_pref.data.local

import android.content.Context
import androidx.core.content.edit
import androidx.datastore.core.DataMigration
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import com.datastore.test.PreferenceKeys
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NotificationPreferences(val context: Context) {
    private val preferences = context.getSharedPreferences("UserData", Context.MODE_PRIVATE)
    private val NOTIFICATION = "notification"

    fun notification(subscribe: Boolean) {
        preferences.edit {
            putBoolean(NOTIFICATION, subscribe)
        }
    }

    fun getSubscribeNotification(): Boolean =
        preferences.getBoolean(NOTIFICATION, false)

    val migration = object : DataMigration<Preferences> {
        val oldKey = booleanPreferencesKey(NOTIFICATION)

        override suspend fun cleanUp() {}

        override suspend fun migrate(currentData: Preferences): Preferences {
            val mutablePreferences = currentData.toMutablePreferences()
            val notification = currentData[oldKey]
            mutablePreferences[PreferenceKeys.Notification.FIELD_NOTIFICATION] =
                if (notification != null) {
                    preferences.getBoolean(NOTIFICATION, false)
                } else {
                    false
                }
            return mutablePreferences
        }

        override suspend fun shouldMigrate(currentData: Preferences): Boolean =
            currentData.contains(oldKey)
    }

}