package com.datastore.test.feature.shared.di

import com.datastore.test.di.ActivityModule
import com.datastore.test.di.ApplicationModule
import com.datastore.test.di.scope.PerWidget
import com.datastore.test.feature.shared.ui.SharedPreferencesFragment
import dagger.Subcomponent

@PerWidget
@Subcomponent(
    modules = [SharedPreferencesModule::class, ActivityModule::class]
)
interface SharedPreferencesComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): SharedPreferencesComponent
    }

    fun inject(sharedPreferencesFragment: SharedPreferencesFragment)
}