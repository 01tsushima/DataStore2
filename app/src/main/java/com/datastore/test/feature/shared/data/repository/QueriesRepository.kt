package com.datastore.test.feature.shared.data.repository

import kotlinx.coroutines.flow.Flow

interface QueriesRepository {

    fun saveQuery(query:String)
    fun fetchQuery(): Flow<Set<String>>
}