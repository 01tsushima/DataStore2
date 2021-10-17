package com.datastore.test.feature.flow.implementation.domain

import com.datastore.test.feature.flow.implementation.data.repository.FlowImplementationRepository

class SaveTokenUseCase(private val repository: FlowImplementationRepository) {

    suspend fun saveToken(token:String){
        repository.saveToken(token)
    }
}