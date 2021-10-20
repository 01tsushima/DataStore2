package com.datastore.test.feature.rx.domain

import com.datastore.test.feature.rx.data.repository.UserDataRepository
import com.datastore.test.feature.rx.domain.model.UserLoginModel
import io.reactivex.Flowable
import javax.inject.Inject

class FetchUserDataUseCase @Inject constructor(
    private val repository: UserDataRepository
) {

    fun invoke(): Flowable<UserLoginModel> {
        return repository.fetchData()
    }
}