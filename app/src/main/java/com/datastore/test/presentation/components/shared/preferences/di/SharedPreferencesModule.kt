package com.datastore.test.presentation.components.shared.preferences.di

import com.datastore.test.di.scope.PerWidget
import com.datastore.test.presentation.components.shared.preferences.domain.SaveQueryUseCase
import com.datastore.test.presentation.components.shared.preferences.ui.SharedPreferencesViewModel
import dagger.Module
import dagger.Provides

@Module
class SharedPreferencesModule {

    @Provides
    @PerWidget
    fun provideSaveQueryUseCase(): SaveQueryUseCase {
        return SaveQueryUseCase()
    }

    @Provides
    @PerWidget
    fun provideViewModel(saveQueryUseCase: SaveQueryUseCase): SharedPreferencesViewModel {
        return SharedPreferencesViewModel(saveQueryUseCase)
    }
}