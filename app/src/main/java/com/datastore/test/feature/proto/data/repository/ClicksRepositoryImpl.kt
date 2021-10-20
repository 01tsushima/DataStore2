package com.datastore.test.feature.proto.data.repository

import com.datastore.test.feature.proto.data.local.ClicksLocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ClicksRepositoryImpl
@Inject constructor(
    private val lds: ClicksLocalDataSource
) : ClicksRepository {

    override suspend fun onNewClick() {
        lds.onNewClick()
    }

    override fun fetchClicks(): Flow<Int> {
        return lds.fetchClicks()
    }
}