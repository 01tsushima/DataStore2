package com.datastore.test.feature.secured.data.local

import com.datastore.test.feature.secured.domain.model.UserLoginModel
import kotlinx.coroutines.flow.Flow

interface UserDataLocalDataSource {

    fun fetchData(): Flow<String>
    suspend fun saveData(data: UserLoginModel)
}