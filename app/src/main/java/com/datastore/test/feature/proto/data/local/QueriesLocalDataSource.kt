package com.datastore.test.feature.proto.data.local

import kotlinx.coroutines.flow.Flow

interface QueriesLocalDataSource {

    fun saveQuery(query:String)
    fun fetchQuery(): Flow<Set<String>>
}