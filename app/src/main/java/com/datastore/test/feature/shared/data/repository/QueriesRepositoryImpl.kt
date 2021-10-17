package com.datastore.test.feature.shared.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class QueriesRepositoryImpl:QueriesRepository {

    override fun saveQuery(query: String) {

    }

    override fun fetchQuery(): Flow<Set<String>> {
        return flow {  }
    }
}