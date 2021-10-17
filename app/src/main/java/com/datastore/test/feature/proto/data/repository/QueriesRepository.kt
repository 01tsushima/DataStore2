package com.datastore.test.feature.proto.data.repository

import kotlinx.coroutines.flow.Flow

interface QueriesRepository {

    fun saveQuery(query:String)
    fun fetchQuery(): Flow<Set<String>>
}