package com.datastore.test.feature.migration_from_pref.ui

import com.datastore.test.core.BaseViewModel
import com.datastore.test.feature.migration_from_pref.domain.SubscribeNotificationUseCase
import javax.inject.Inject

class MigrationFromSharedPreferencesViewModel
@Inject
constructor(
    private val subscribeNotificationUseCase: SubscribeNotificationUseCase
) : BaseViewModel() {
    fun getNotification() =
        subscribeNotificationUseCase.invoke()
}