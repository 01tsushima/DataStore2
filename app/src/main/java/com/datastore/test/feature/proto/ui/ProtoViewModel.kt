package com.datastore.test.feature.proto.ui

import com.datastore.test.core.base.BaseViewModel
import com.datastore.test.feature.proto.domain.FetchQueriesUseCase
import com.datastore.test.feature.proto.domain.SaveQueryUseCase
import javax.inject.Inject

class ProtoViewModel @Inject constructor(
    private val saveQueryUseCase: SaveQueryUseCase,
    private val fetchQueries: FetchQueriesUseCase

) : BaseViewModel() {

    val queriesFlow = fetchQueries.fetchQueries()

    fun saveNewSearch(query: String) {
        saveQueryUseCase.saveQuery(query)
    }
}