package com.datastore.test.feature.shared.ui

import com.datastore.test.core.base.BaseViewModel
import com.datastore.test.feature.shared.domain.FetchQueriesUseCase
import com.datastore.test.feature.shared.domain.SaveQueryUseCase

class SharedPreferencesViewModel(
    private val saveQueryUseCase: SaveQueryUseCase,
    private val fetchQueries: FetchQueriesUseCase

) : BaseViewModel() {

    val queriesFlow = fetchQueries.fetchQueries()

    fun saveNewSearch(query: String) {
        saveQueryUseCase.saveQuery(query)
    }
}