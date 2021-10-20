package com.datastore.test.feature.secured.di

import com.datastore.test.feature.secured.data.local.UserDataLocalDataSource
import com.datastore.test.feature.secured.data.local.UserDataLocalDataSourceImpl
import com.datastore.test.feature.secured.data.repository.UserDataRepository
import com.datastore.test.feature.secured.data.repository.UserDataRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class SecureDatastoreModule {

    @Binds
    internal abstract fun bindUserDataRepository(repository: UserDataRepositoryImpl)
            : UserDataRepository

    @Binds
    internal abstract fun bindUserDataLocalDataSource(lds:UserDataLocalDataSourceImpl):UserDataLocalDataSource

}