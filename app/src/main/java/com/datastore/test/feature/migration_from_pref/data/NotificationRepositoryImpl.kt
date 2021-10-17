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
        val l = 0
        return notificationLocalDataSource.notification(subscribe)
    }
}