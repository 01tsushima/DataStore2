package com.datastore.test.feature.migration_from_pref.domain

import com.datastore.test.feature.migration_from_pref.data.NotificationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSubscribeUseCase
@Inject constructor(
    private val notificationRepository: NotificationRepository
) {
    fun invoke(): Flow<Boolean> = notificationRepository.getNotification()
}