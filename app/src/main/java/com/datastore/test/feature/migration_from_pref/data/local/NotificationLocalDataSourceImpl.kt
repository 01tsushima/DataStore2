package com.datastore.test.feature.migration_from_pref.data.local

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NotificationLocalDataSourceImpl
@Inject constructor(
    private val notificationPreferences: NotificationPreferences
) : NotificationLocalDataSource{
    override fun getSubscribeNotification(): Flow<Boolean> = flow {
        emit(
            notificationPreferences.getSubscribeNotification()
        )
    }

    override suspend fun notification(subscribe: Boolean) {
        val l = 0
        return notificationPreferences.notification(subscribe)
    }
}