package com.datastore.test.feature.migration_from_pref.data

import kotlinx.coroutines.flow.Flow

interface NotificationRepository {
    fun getNotification(): Flow<Boolean>
    suspend fun notification(subscribe: Boolean)
}