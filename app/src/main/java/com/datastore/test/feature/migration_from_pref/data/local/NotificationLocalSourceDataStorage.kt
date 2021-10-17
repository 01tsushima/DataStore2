package com.datastore.test.feature.migration_from_pref.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.datastore.test.PreferenceKeys
import com.datastore.test.core.get
import com.datastore.test.data.local.DataStoreManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class NotificationLocalSourceDataStorage
@Inject
constructor(
    private val notificationPreferences: NotificationPreferences,
) : NotificationLocalDataSource {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
        "dataStoreNotification",
        produceMigrations = {
            listOf(
                SharedPreferencesMigration(it, "shared_pref"),
                notificationPreferences.migration
            )
        }
    )

    override fun getSubscribeNotification(): Flow<Boolean> =
        notificationPreferences.context.dataStore.data.catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map {
            it[PreferenceKeys.Notification.FIELD_NOTIFICATION] ?: false
        }

    override suspend fun notification(subscribe: Boolean) {
        val l = 0
        notificationPreferences.context.dataStore.edit {
            it[PreferenceKeys.Notification.FIELD_NOTIFICATION] = subscribe
        }
    }
}