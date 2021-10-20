package com.datastore.test.feature.secured.di

import com.datastore.test.di.activity.ActivityModule
import com.datastore.test.di.scope.PerWidget
import com.datastore.test.feature.secured.ui.SecureDatastoreFragment
import dagger.Subcomponent

@PerWidget
@Subcomponent(
    modules = [SecureDatastoreModule::class, ActivityModule::class]
)
interface SecureDatastoreComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): SecureDatastoreComponent
    }

    fun inject(secureDatastoreFragment: SecureDatastoreFragment)
}