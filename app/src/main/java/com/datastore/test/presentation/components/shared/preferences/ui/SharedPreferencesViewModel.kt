package com.datastore.test.presentation.components.shared.preferences.ui

import com.datastore.test.core.BaseViewModel
import com.datastore.test.presentation.components.shared.preferences.domain.SaveQueryUseCase

class SharedPreferencesViewModel(private val saveQueryUseCase: SaveQueryUseCase):BaseViewModel() {

    fun saveNewSearch(query:String){
        saveQueryUseCase.saveQuery(query)
    }
}