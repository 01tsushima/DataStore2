package com.datastore.test.feature.rx.di

import com.datastore.test.di.activity.ActivityModule
import com.datastore.test.di.scope.PerWidget
import com.datastore.test.feature.rx.ui.RxDatastoreFragment
import dagger.Subcomponent

@PerWidget
@Subcomponent(
    modules = [RxDatastoreModule::class, ActivityModule::class]
)
interface RxDatastoreComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): RxDatastoreComponent
    }

    fun inject(rxDatastoreFragment: RxDatastoreFragment)
}