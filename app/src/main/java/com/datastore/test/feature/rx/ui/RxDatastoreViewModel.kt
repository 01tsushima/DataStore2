package com.datastore.test.feature.rx.ui

import androidx.lifecycle.viewModelScope
import com.datastore.test.core.base.BaseViewModel
import com.datastore.test.feature.rx.domain.FetchUserDataUseCase
import com.datastore.test.feature.rx.domain.SaveUserDataUseCase
import com.datastore.test.feature.rx.domain.model.UserLoginModel
import javax.inject.Inject

class RxDatastoreViewModel @Inject constructor(
    private val fetchUserDataUseCase: FetchUserDataUseCase,
    private val saveUserDataUseCase: SaveUserDataUseCase
) : BaseViewModel() {

    val userData = fetchUserDataUseCase.invoke()

    fun saveUserData(login: String, password: String) {
        viewModelScope.execute {
            saveUserDataUseCase.invoke(UserLoginModel(login, password))
        }
    }
}