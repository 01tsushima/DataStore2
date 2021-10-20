package com.datastore.test.feature.rx.data.repository

import com.datastore.test.feature.rx.data.local.UserDataLocalDataSource
import com.datastore.test.feature.rx.domain.model.UserLoginModel
import io.reactivex.Flowable
import javax.inject.Inject

class UserDataRepositoryImpl @Inject constructor(
    val lds: UserDataLocalDataSource
) : UserDataRepository {

    override fun fetchData(): Flowable<UserLoginModel> {
        return lds.fetchData()
    }

    override suspend fun saveData(data: UserLoginModel) {
        lds.saveData(data)
    }


}