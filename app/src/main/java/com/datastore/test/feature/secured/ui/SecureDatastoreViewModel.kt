package com.datastore.test.feature.secured.ui

import androidx.lifecycle.viewModelScope
import com.datastore.test.core.base.BaseViewModel
import com.datastore.test.feature.secured.domain.FetchUserDataUseCase
import com.datastore.test.feature.secured.domain.SaveUserDataUseCase
import com.datastore.test.feature.secured.domain.model.UserLoginModel
import javax.inject.Inject

class SecureDatastoreViewModel @Inject constructor(
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