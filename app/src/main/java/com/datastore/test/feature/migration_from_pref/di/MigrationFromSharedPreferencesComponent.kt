package com.datastore.test.feature.migration_from_pref.di

import com.datastore.test.feature.migration_from_pref.ui.MigrationFromSharedPreferencesFragment
import dagger.Subcomponent

@Subcomponent(
    modules = [
        MigrateFromSharedPreferencesDataModule::class
    ]
)
interface MigrationFromSharedPreferencesComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): MigrationFromSharedPreferencesComponent
    }

    fun inject(fragmentMigrateFromSharedPreferencesFragment: MigrationFromSharedPreferencesFragment)
}