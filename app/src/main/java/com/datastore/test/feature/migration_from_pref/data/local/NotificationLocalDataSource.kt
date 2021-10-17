package com.datastore.test.feature.migration_from_pref.data.local

interface NotificationLocalDataSource {
    fun getSubscribeNotification(): Boolean
    fun notification(subscribe: Boolean)
}