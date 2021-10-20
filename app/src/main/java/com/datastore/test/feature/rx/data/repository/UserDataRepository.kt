package com.datastore.test.feature.rx.data.repository

import com.datastore.test.feature.rx.domain.model.UserLoginModel
import io.reactivex.Flowable

interface UserDataRepository {

    fun fetchData(): Flowable<UserLoginModel>
    suspend fun saveData(data: UserLoginModel)
}