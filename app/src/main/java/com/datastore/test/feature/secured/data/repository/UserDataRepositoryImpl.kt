package com.datastore.test.feature.secured.data.repository

import com.datastore.test.feature.secured.data.local.UserDataLocalDataSource
import com.datastore.test.feature.secured.domain.model.UserLoginModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserDataRepositoryImpl @Inject constructor(
    val lds: UserDataLocalDataSource
) : UserDataRepository {
    override fun fetchData(): Flow<String> {
        return lds.fetchData()
    }

    override suspend fun saveData(data: UserLoginModel) {
        lds.saveData(data)
    }


}