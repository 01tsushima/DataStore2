package com.datastore.test.feature.migration_from_pref.data

import com.datastore.test.feature.migration_from_pref.data.local.NotificationLocalDataSource
import javax.inject.Inject

class NotificationRepositoryImpl
@Inject
constructor(
    private val notificationLocalDataSource: NotificationLocalDataSource
) : NotificationRepository {
    override fun getNotification() =
        notificationLocalDataSource.getSubscribeNotification()
}