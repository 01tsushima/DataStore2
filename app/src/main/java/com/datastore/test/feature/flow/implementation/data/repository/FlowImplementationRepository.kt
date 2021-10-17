package com.datastore.test.feature.flow.implementation.data.repository

import kotlinx.coroutines.flow.Flow

interface FlowImplementationRepository {

    val token: Flow<String?>

    suspend fun login(login: String, password: String): String
    suspend fun saveToken(token: String)
}