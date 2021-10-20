package com.datastore.test.feature.proto.di

import com.datastore.test.feature.proto.data.local.ClicksLocalDataSource
import com.datastore.test.feature.proto.data.local.ClicksLocalDataSourceImpl
import com.datastore.test.feature.proto.data.repository.ClicksRepository
import com.datastore.test.feature.proto.data.repository.ClicksRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class ProtoModule {

    @Binds
    internal abstract fun bindQueriesLocalDataSource(
        lds: ClicksLocalDataSourceImpl
    ): ClicksLocalDataSource

    @Binds
    internal abstract fun bindQueriesRepository(
        repository: ClicksRepositoryImpl
    ): ClicksRepository
}