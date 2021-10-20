package com.datastore.test.feature.proto.ui

import androidx.lifecycle.viewModelScope
import com.datastore.test.core.base.BaseViewModel
import com.datastore.test.feature.proto.domain.FetchClicksUseCase
import com.datastore.test.feature.proto.domain.NewClickUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProtoViewModel @Inject constructor(
    private val newClickUseCase: NewClickUseCase,
    private val fetchClicksUseCase: FetchClicksUseCase
) : BaseViewModel() {

    val clicks: Flow<Int> = fetchClicksUseCase.invoke()

    fun onNewClick() {
        viewModelScope.execute {
            newClickUseCase.invoke()
        }
    }
}