package com.datastore.test.utils

import android.content.Context
import androidx.datastore.core.DataMigration
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.datastore.test.PreferenceKeys

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = PreferenceKeys.DataStore.Name,
    produceMigrations = { context ->
        listOf(
            SharedPreferencesMigration(context, PreferenceKeys.SharedPreferences.Name),
            migration
        )
    })

val migration = object : DataMigration<Preferences> {

    val oldKey = booleanPreferencesKey(PreferenceKeys.FileDeliveryOld.FIELD_DELIVERY_OLD.name)

    override suspend fun cleanUp() {}

    override suspend fun migrate(currentData: Preferences): Preferences {
        val mutablePrefs = currentData.toMutablePreferences()
        val fileDelivered = currentData[oldKey]
        mutablePrefs[PreferenceKeys.FileDeliveryNew.FIELD_DELIVERY_NEW] =
            when (fileDelivered) {
                false -> 0
                true -> 1
                null -> 2
            }
        return mutablePrefs
    }

    override suspend fun shouldMigrate(currentData: Preferences): Boolean {
        return currentData.contains(oldKey)
    }
}
