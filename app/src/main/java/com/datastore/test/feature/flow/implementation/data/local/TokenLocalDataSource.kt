package com.datastore.test.feature.flow.implementation.data.local

import kotlinx.coroutines.flow.Flow

interface TokenLocalDataSource {

    fun token(): Flow<String>

    suspend fun saveToken(string: String)
}