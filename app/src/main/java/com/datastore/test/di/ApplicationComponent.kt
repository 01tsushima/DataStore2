package com.datastore.test.di

import android.content.Context
import com.datastore.test.di.scope.PerApplication
import com.datastore.test.feature.migration_from_pref.di.MigrateFromSharedPreferencesDataModule
import com.datastore.test.feature.migration_from_pref.di.MigrationFromSharedPreferencesComponent
import com.datastore.test.feature.shared.di.SharedPreferencesComponent
import dagger.BindsInstance
import dagger.Component

@PerApplication
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent : ApplicationComponentProxy {

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent

        @BindsInstance
        fun context(context: Context): Builder
    }

    fun sharedPreferencesComponentBuilder(): SharedPreferencesComponent.Builder
    fun migrationFromSharedPreferencesBuilder(): MigrationFromSharedPreferencesComponent.Builder
}