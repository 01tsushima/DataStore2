package com.datastore.test.feature.migration_from_pref.data.local

import android.content.Context
import androidx.core.content.edit

class NotificationPreferences(context: Context) {
    private val preferences = context.getSharedPreferences("UserData", Context.MODE_PRIVATE)
    private val NOTIFICATION = "notification"

    fun notification(subscribe: Boolean) {
        preferences.edit {
            putBoolean(NOTIFICATION, subscribe)
        }
    }

    fun getSubscribeNotification(): Boolean =
        preferences.getBoolean(NOTIFICATION, false)
}