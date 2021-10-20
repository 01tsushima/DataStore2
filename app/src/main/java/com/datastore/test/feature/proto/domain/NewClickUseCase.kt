package com.datastore.test.feature.proto.domain

import com.datastore.test.feature.proto.data.repository.ClicksRepository
import javax.inject.Inject

class NewClickUseCase @Inject constructor(private val clicksRepository: ClicksRepository) {

    suspend fun invoke() {
        clicksRepository.onNewClick()
    }
}