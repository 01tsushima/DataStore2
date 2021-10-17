package com.datastore.test.feature.migration_from_pref.ui

import com.datastore.test.core.base.BaseViewModel
import com.datastore.test.feature.migration_from_pref.domain.GetSubscribeUseCase
import com.datastore.test.feature.migration_from_pref.domain.SubscribeNotificationUseCase
import javax.inject.Inject

class MigrationFromSharedPreferencesViewModel
@Inject
constructor(
    private val subscribeNotificationUseCase: SubscribeNotificationUseCase,
    private val getSubscribeUseCase: GetSubscribeUseCase
) : BaseViewModel() {

    fun notification(subscribe: Boolean) =
        subscribeNotificationUseCase.invoke(subscribe)

    fun getSubscribe(): Boolean =
        getSubscribeUseCase.invoke()
}