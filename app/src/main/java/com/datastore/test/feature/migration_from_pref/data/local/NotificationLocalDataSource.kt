package com.datastore.test.feature.migration_from_pref.data.local

import kotlinx.coroutines.flow.Flow

interface NotificationLocalDataSource {
    fun getSubscribeNotification(): Flow<Boolean>
    suspend fun setNotification(subscribe: Boolean)
    suspend fun setNotificationFromShared(subscribe: Boolean)
}