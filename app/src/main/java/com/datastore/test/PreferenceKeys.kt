package com.datastore.test

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object PreferenceKeys {
    object Token{
        private const val Token = "Token"
        val FIELD_TOKEN = stringPreferencesKey(Token)
    }

    object Notification {
        private const val NOTIFICATION = "Notification"
        val FIELD_NOTIFICATION = booleanPreferencesKey(NOTIFICATION)
    }
}