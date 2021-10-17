package com.datastore.test.feature.flow.implementation.domain

import com.datastore.test.feature.flow.implementation.data.repository.FlowImplementationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchLocalTokenUseCase @Inject constructor(repository:FlowImplementationRepository) {

    val token: Flow<String?> = repository.token
}