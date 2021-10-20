package com.datastore.test.di.application

import android.content.Context
import com.datastore.test.di.scope.PerApplication
import com.datastore.test.feature.flow.implementation.di.FlowImplementationComponent
import com.datastore.test.feature.migration_from_pref.di.MigrationFromSharedPreferencesComponent
import com.datastore.test.feature.proto.di.ProtoComponent
import com.datastore.test.feature.secured.di.SecureDatastoreComponent
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

    fun protoBuilder(): ProtoComponent.Builder
    fun migrationFromSharedPreferencesBuilder(): MigrationFromSharedPreferencesComponent.Builder
    fun flowImplementationBuilder(): FlowImplementationComponent.Builder
    fun secureDataStoreBuilder(): SecureDatastoreComponent.Builder
}