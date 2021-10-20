package com.datastore.test.feature.secured.data.local

import com.datastore.test.feature.secured.domain.model.UserLoginModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class UserDataLocalDataSourceImpl @Inject constructor(

) : UserDataLocalDataSource {

    override fun fetchData(): Flow<String> {
        return flowOf("")
    }


    override suspend fun saveData(data: UserLoginModel) {

    }
}