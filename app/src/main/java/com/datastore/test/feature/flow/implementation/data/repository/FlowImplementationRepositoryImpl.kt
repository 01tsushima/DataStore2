package com.datastore.test.feature.flow.implementation.data.repository

import com.datastore.test.feature.flow.implementation.data.local.TokenLocalDataSource
import com.datastore.test.feature.flow.implementation.data.remote.TokenRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FlowImplementationRepositoryImpl
@Inject constructor(
    private val rds: TokenRemoteDataSource,
    private val lds: TokenLocalDataSource
) : FlowImplementationRepository {

   override val token: Flow<String> = lds.token

    override suspend fun login(login: String, password: String): String {
        return rds.login(login, password)
    }

    override suspend fun saveToken(token: String) {
        lds.saveToken(token)
    }
}