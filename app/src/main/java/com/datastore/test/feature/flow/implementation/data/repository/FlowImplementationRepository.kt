package com.datastore.test.feature.flow.implementation.data.repository

import com.datastore.test.feature.flow.implementation.data.local.TokenLocalDataSource
import com.datastore.test.feature.flow.implementation.data.remote.TokenRemoteDataSource

class FlowImplementationRepository(
    private val rds: TokenRemoteDataSource,
    private val lds: TokenLocalDataSource
) {

    suspend fun login(login: String, password: String): String {
        return rds.login(login, password)
    }

    suspend fun saveToken(token: String) {
        lds.saveToken(token)
    }
}