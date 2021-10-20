package com.datastore.test.feature.proto.data.local

import kotlinx.coroutines.flow.Flow

interface ClicksLocalDataSource {

    suspend fun onNewClick()
     fun fetchClicks(): Flow<Int>
}