package com.datastore.test.feature.flow.implementation.di

import com.datastore.test.di.scope.PerWidget
import com.datastore.test.feature.flow.implementation.domain.FetchLocalTokenUseCase
import com.datastore.test.feature.flow.implementation.domain.GetRemoteTokenUseCase
import com.datastore.test.feature.flow.implementation.domain.SaveTokenUseCase
import dagger.Module
import dagger.Provides

@Module
class FlowImplementationModule {

    @Provides
    @PerWidget
    fun provideFetchLocalTokenUseCase(): FetchLocalTokenUseCase {
        return FetchLocalTokenUseCase()
    }

    @Provides
    @PerWidget
    fun provideGetRemoteTokenUseCase(): GetRemoteTokenUseCase {
        return GetRemoteTokenUseCase()
    }

    @Provides
    @PerWidget
    fun provideSaveTokenUseCase(): SaveTokenUseCase {
        return SaveTokenUseCase()
    }
}