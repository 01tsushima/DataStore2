package com.datastore.test.feature.rx.data.local

import com.datastore.test.feature.rx.domain.model.UserLoginModel
import io.reactivex.Flowable

interface UserDataLocalDataSource {

    fun fetchData(): Flowable<UserLoginModel>
    suspend fun saveData(data: UserLoginModel)
}