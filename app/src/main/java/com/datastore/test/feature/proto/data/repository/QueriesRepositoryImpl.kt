package com.datastore.test.feature.proto.data.repository

import com.datastore.test.feature.proto.data.local.QueriesLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class QueriesRepositoryImpl
@Inject constructor(
    private val lds: QueriesLocalDataSource
) : QueriesRepository {

    override fun saveQuery(query: String) {

    }

    override fun fetchQuery(): Flow<Set<String>> {
        return flow { }
    }
}