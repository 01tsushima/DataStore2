package com.datastore.test.di

import android.content.Context
import android.content.SharedPreferences
import com.datastore.test.di.scope.PerApplication
import com.datastore.test.presentation.components.shared.preferences.di.SharedPreferencesComponent
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
}