package com.datastore.test.feature.flow.implementation.domain

import com.datastore.test.feature.flow.implementation.data.repository.FlowImplementationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchLocalTokenUseCase
@Inject constructor(private val repository: FlowImplementationRepository) {

    fun invoke(): Flow<String?> {
        return repository.token
    }
}