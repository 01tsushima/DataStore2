package com.datastore.test.feature.shared.di

import com.datastore.test.di.scope.PerWidget
import com.datastore.test.feature.shared.domain.SaveQueryUseCase
import com.datastore.test.feature.shared.ui.SharedPreferencesViewModel
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