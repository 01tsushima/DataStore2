package com.datastore.test.feature.flow.implementation.domain

import com.datastore.test.feature.flow.implementation.data.repository.FlowImplementationRepository
import javax.inject.Inject

class GetRemoteTokenUseCase @Inject constructor(private val repository: FlowImplementationRepository) {

    suspend fun invoke(login:String,password:String):String{
        return repository.login(login,password)
    }
}