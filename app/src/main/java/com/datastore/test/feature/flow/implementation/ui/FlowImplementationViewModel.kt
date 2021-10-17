package com.datastore.test.feature.flow.implementation.ui

import androidx.lifecycle.viewModelScope
import com.datastore.test.core.base.BaseViewModel
import com.datastore.test.feature.flow.implementation.domain.FetchLocalTokenUseCase
import com.datastore.test.feature.flow.implementation.domain.GetRemoteTokenUseCase
import com.datastore.test.feature.flow.implementation.domain.SaveTokenUseCase

class FlowImplementationViewModel(
    private val getRemoteTokenUseCase: GetRemoteTokenUseCase,
    private val saveTokenUseCase: SaveTokenUseCase,
    private val fetchLocalTokenUseCase: FetchLocalTokenUseCase
) : BaseViewModel() {


    fun login(login: String, password: String) {
        viewModelScope.execute {
            val token = getRemoteTokenUseCase.getToken(login, password)
            saveToken(token)
        }
    }

    fun saveToken(token:String){
        viewModelScope.execute { saveTokenUseCase.saveToken(token) }
    }
}