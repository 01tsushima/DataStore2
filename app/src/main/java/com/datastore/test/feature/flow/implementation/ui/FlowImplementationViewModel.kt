package com.datastore.test.feature.flow.implementation.ui

import androidx.lifecycle.viewModelScope
import com.datastore.test.core.base.BaseViewModel
import com.datastore.test.feature.flow.implementation.domain.FetchLocalTokenUseCase
import com.datastore.test.feature.flow.implementation.domain.GetRemoteTokenUseCase
import com.datastore.test.feature.flow.implementation.domain.SaveTokenUseCase
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject

class FlowImplementationViewModel @Inject constructor(
    private val getRemoteTokenUseCase: GetRemoteTokenUseCase,
    private val saveTokenUseCase: SaveTokenUseCase,
    private val fetchLocalTokenUseCase: FetchLocalTokenUseCase
) : BaseViewModel() {

    val showTokenFlow = fetchLocalTokenUseCase.token.distinctUntilChanged()

    fun login(login: String, password: String) {
        viewModelScope.execute {
            val token = getRemoteTokenUseCase.getToken(login, password)
            saveToken(token)
        }
    }

    private fun saveToken(token: String) {
        viewModelScope.execute { saveTokenUseCase.saveToken(token) }
    }
}