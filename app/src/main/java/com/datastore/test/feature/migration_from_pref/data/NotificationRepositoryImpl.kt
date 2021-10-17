package com.datastore.test.feature.migration_from_pref.data

import com.datastore.test.feature.migration_from_pref.data.local.NotificationLocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NotificationRepositoryImpl
@Inject
constructor(
    private val notificationLocalDataSource: NotificationLocalDataSource
) : NotificationRepository {
    override fun getNotification(): Flow<Boolean> =
        notificationLocalDataSource.getSubscribeNotification()

    override suspend fun notification(subscribe: Boolean) {
         notificationLocalDataSource.setNotification(subscribe)
    }

    override suspend fun setNotificationFromShared(subscribe: Boolean) {
        notificationLocalDataSource.setNotificationFromShared(subscribe)
    }
}