package com.datastore.test.feature.proto.di

import com.datastore.test.feature.proto.data.local.QueriesLocalDataSource
import com.datastore.test.feature.proto.data.local.QueriesLocalDataSourceImpl
import com.datastore.test.feature.proto.data.repository.QueriesRepository
import com.datastore.test.feature.proto.data.repository.QueriesRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class ProtoModule {

    @Binds
    internal abstract fun bindQueriesLocalDataSource(
        lds: QueriesLocalDataSourceImpl
    ): QueriesLocalDataSource

    @Binds
    internal abstract fun bindQueriesRepository(
        repository: QueriesRepositoryImpl
    ): QueriesRepository
}