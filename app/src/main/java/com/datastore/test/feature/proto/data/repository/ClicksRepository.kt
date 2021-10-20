package com.datastore.test.feature.proto.data.repository

import kotlinx.coroutines.flow.Flow

interface ClicksRepository {

    suspend fun onNewClick()
    fun fetchClicks(): Flow<Int>
}