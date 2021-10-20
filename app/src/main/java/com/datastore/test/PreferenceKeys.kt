package com.datastore.test

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object PreferenceKeys {
    object Token {
        private const val Token = "Token"
        val FIELD_TOKEN = stringPreferencesKey(Token)
    }

    object Notification {
        private const val NOTIFICATION = "Notification"
        val FIELD_NOTIFICATION = booleanPreferencesKey(NOTIFICATION)
    }

    object FileDeliveryOld {
        private const val FileDeliveryOld = "File delivery Old"
        val FIELD_DELIVERY_OLD = booleanPreferencesKey(FileDeliveryOld)
    }

    object FileDeliveryNew {
        private const val FileDelivery = "File delivery"
        val FIELD_DELIVERY_NEW = intPreferencesKey(FileDelivery)
    }

    object NotificationInSharedPreferences {
        const val NOTIFICATION = "Notification"
    }

    object SharedPreferences {
        const val Name = "Shared_Prefs"
    }

    object DataStore {
        const val Name = "DataStore"
    }


    object SecureKey {
        const val KEYSET_NAME = "master_keyset"
        const val PREFERENCE_FILE = "master_key_preference"
        const val MASTER_KEY_URI = "android-keystore://master_key"
    }
}