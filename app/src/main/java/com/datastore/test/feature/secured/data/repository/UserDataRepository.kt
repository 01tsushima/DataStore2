package com.datastore.test.feature.secured.data.repository

import com.datastore.test.feature.secured.domain.model.UserLoginModel
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {

    fun fetchData(): Flow<String>
    suspend fun saveData(data: UserLoginModel)
}