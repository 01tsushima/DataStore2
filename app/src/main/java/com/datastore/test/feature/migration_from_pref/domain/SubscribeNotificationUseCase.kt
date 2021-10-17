package com.datastore.test.feature.migration_from_pref.domain

import com.datastore.test.feature.migration_from_pref.data.NotificationRepository
import javax.inject.Inject

class SubscribeNotificationUseCase
@Inject constructor(
    private val notificationRepository: NotificationRepository
) {
    suspend fun invoke(isSubscribe: Boolean) =
        notificationRepository.notification(isSubscribe)
}