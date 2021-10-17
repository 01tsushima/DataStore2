package com.datastore.test.feature.flow.implementation.di

import com.datastore.test.feature.flow.implementation.data.local.TokenLocalDataSource
import com.datastore.test.feature.flow.implementation.data.local.TokenLocalDataSourceImpl
import com.datastore.test.feature.flow.implementation.data.remote.TokenRemoteDataSource
import com.datastore.test.feature.flow.implementation.data.remote.TokenRemoteDataSourceImpl
import com.datastore.test.feature.flow.implementation.data.repository.FlowImplementationRepository
import com.datastore.test.feature.flow.implementation.data.repository.FlowImplementationRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class FlowImplementationModule {

    @Binds
    internal abstract fun bindTokenLocalDataSource(lds: TokenLocalDataSourceImpl):TokenLocalDataSource

    @Binds
    internal abstract fun bindTokenRemoteDataSource(rds:TokenRemoteDataSourceImpl): TokenRemoteDataSource

    @Binds
    internal abstract fun bindFlowImplementationRepository(repository:FlowImplementationRepositoryImpl)
    :FlowImplementationRepository
}