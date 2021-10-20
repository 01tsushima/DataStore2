package com.datastore.test.feature.secured.domain

import com.datastore.test.feature.secured.data.repository.UserDataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchUserDataUseCase @Inject constructor(
    private val repository: UserDataRepository
) {

    fun invoke(): Flow<String> {
        return repository.fetchData()
    }
}