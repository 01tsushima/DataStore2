package com.datastore.test.feature.rx.di

import com.datastore.test.feature.rx.data.local.UserDataLocalDataSource
import com.datastore.test.feature.rx.data.local.UserDataLocalDataSourceImpl
import com.datastore.test.feature.rx.data.repository.UserDataRepository
import com.datastore.test.feature.rx.data.repository.UserDataRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RxDatastoreModule {

    @Binds
    internal abstract fun bindUserDataRepository(repository: UserDataRepositoryImpl)
            : UserDataRepository

    @Binds
    internal abstract fun bindUserDataLocalDataSource(lds:UserDataLocalDataSourceImpl):UserDataLocalDataSource

}