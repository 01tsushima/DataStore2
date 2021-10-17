package com.datastore.test.feature.migration_from_pref.di

import com.datastore.test.feature.migration_from_pref.data.NotificationRepository
import com.datastore.test.feature.migration_from_pref.data.NotificationRepositoryImpl
import com.datastore.test.feature.migration_from_pref.data.local.NotificationLocalDataSource
import com.datastore.test.feature.migration_from_pref.data.local.NotificationLocalDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class MigrateFromSharedPreferencesDataModule {
    @Binds
    internal abstract fun bindNotificationRepository(notificationRepositoryImpl: NotificationRepositoryImpl) : NotificationRepository

    @Binds
    internal abstract fun bindNotificationLocalSource(notificationLocalDataSourceImpl: NotificationLocalDataSourceImpl): NotificationLocalDataSource
}