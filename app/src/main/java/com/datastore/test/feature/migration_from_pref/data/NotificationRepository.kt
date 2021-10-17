package com.datastore.test.feature.migration_from_pref.data

interface NotificationRepository {
    fun getNotification(): Boolean
    fun notification(subscribe: Boolean)
}