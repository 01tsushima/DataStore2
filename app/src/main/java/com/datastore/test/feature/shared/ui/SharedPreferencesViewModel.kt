package com.datastore.test.feature.shared.ui

import com.datastore.test.core.base.BaseViewModel
import com.datastore.test.feature.shared.domain.SaveQueryUseCase

class SharedPreferencesViewModel(private val saveQueryUseCase: SaveQueryUseCase): BaseViewModel() {

    fun saveNewSearch(query:String){
        saveQueryUseCase.saveQuery(query)
    }
}