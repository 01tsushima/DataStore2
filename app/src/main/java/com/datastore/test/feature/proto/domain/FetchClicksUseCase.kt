package com.datastore.test.feature.proto.domain

import com.datastore.test.feature.proto.data.repository.ClicksRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchClicksUseCase @Inject constructor(private val clicksRepository: ClicksRepository) {

    fun invoke(): Flow<Int> {
        return clicksRepository.fetchClicks()
    }
}