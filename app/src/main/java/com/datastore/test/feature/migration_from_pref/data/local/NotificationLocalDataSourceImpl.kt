package com.datastore.test.feature.migration_from_pref.data.local

import javax.inject.Inject

class NotificationLocalDataSourceImpl
@Inject constructor(
    private val notificationPreferences: NotificationPreferences
) : NotificationLocalDataSource{
    override fun getSubscribeNotification() =
        notificationPreferences.getSubscribeNotification()
}