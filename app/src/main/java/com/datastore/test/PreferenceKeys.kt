package com.datastore.test

import androidx.datastore.preferences.core.stringPreferencesKey

object PreferenceKeys {
    object Token{
        private const val Token = "Token"
        val FIELD_TOKEN = stringPreferencesKey(Token)
    }
}