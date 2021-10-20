package com.datastore.test.feature.rx.domain

import com.datastore.test.feature.rx.data.repository.UserDataRepository
import com.datastore.test.feature.rx.domain.model.UserLoginModel
import javax.inject.Inject

class SaveUserDataUseCase @Inject constructor(
    val repository: UserDataRepository
) {

    suspend fun invoke(data:UserLoginModel){
        repository.saveData(data)
    }
}