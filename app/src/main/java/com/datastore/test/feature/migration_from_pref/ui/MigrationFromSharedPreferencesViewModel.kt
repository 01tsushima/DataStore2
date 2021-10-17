package com.datastore.test.feature.migration_from_pref.ui

import androidx.lifecycle.viewModelScope
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

    val notification = getSubscribeUseCase.invoke()

    fun notification(subscribe: Boolean) {
        val l = 0
        viewModelScope.execute {
            subscribeNotificationUseCase.invoke(subscribe)
        }
    }
}