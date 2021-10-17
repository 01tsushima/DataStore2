package com.datastore.test.feature.migration_from_pref.domain

import com.datastore.test.feature.migration_from_pref.data.NotificationRepository
import javax.inject.Inject

class SubscribeNotificationUseCase
@Inject constructor(
    private val notificationRepository: NotificationRepository
) {
    fun invoke() {
        val l = notificationRepository.getNotification()
    }
}