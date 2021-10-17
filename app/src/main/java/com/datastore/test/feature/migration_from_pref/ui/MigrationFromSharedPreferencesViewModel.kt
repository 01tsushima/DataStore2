package com.datastore.test.feature.migration_from_pref.ui

import androidx.lifecycle.viewModelScope
import com.datastore.test.core.base.BaseViewModel
import com.datastore.test.feature.migration_from_pref.domain.ChangeSubscriptionFromSharedUseCase
import com.datastore.test.feature.migration_from_pref.domain.GetSubscribeUseCase
import com.datastore.test.feature.migration_from_pref.domain.SubscribeNotificationUseCase
import javax.inject.Inject

class MigrationFromSharedPreferencesViewModel
@Inject
constructor(
    private val subscribeNotificationUseCase: SubscribeNotificationUseCase,
    private val getSubscribeUseCase: GetSubscribeUseCase,
    private val changeSubscriptionFromSharedUseCase: ChangeSubscriptionFromSharedUseCase
) : BaseViewModel() {

    val notification = getSubscribeUseCase.invoke()

    fun notification(subscribe: Boolean) {
        viewModelScope.execute {
            subscribeNotificationUseCase.invoke(subscribe)
        }
    }

    fun changeFromShared(subscribe: Boolean) {
        viewModelScope.execute {
            changeSubscriptionFromSharedUseCase.invoke(subscribe)
        }
    }
}