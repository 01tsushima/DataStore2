package com.datastore.test.feature.flow.implementation.domain

import com.datastore.test.feature.flow.implementation.data.repository.FlowImplementationRepository

class GetRemoteTokenUseCase(private val repository: FlowImplementationRepository) {

    suspend fun getToken(login:String,password:String):String{
        return repository.login(login,password)
    }
}