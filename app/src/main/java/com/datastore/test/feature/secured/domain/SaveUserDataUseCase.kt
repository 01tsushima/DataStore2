package com.datastore.test.feature.secured.domain

import com.datastore.test.feature.secured.data.repository.UserDataRepository
import com.datastore.test.feature.secured.domain.model.UserLoginModel
import javax.inject.Inject

class SaveUserDataUseCase @Inject constructor(
    val repository: UserDataRepository
) {

    suspend fun invoke(data:UserLoginModel){
        repository.saveData(data)
    }
}