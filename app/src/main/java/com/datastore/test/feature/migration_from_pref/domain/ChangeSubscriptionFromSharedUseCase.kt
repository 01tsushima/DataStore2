package com.datastore.test.feature.migration_from_pref.domain

import com.datastore.test.feature.migration_from_pref.data.NotificationRepository
import javax.inject.Inject

class ChangeSubscriptionFromSharedUseCase @Inject constructor(
    private val repository:NotificationRepository
) {
    suspend fun invoke(subscription:Boolean){
        repository.setNotificationFromShared(subscription)
    }
}