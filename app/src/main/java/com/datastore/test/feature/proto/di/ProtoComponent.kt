package com.datastore.test.feature.proto.di

import com.datastore.test.di.activity.ActivityModule
import com.datastore.test.di.scope.PerWidget
import com.datastore.test.feature.proto.ui.ProtoFragment
import dagger.Subcomponent

@PerWidget
@Subcomponent(
    modules = [ProtoModule::class, ActivityModule::class]
)
interface ProtoComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): ProtoComponent
    }

    fun inject(protoFragment: ProtoFragment)
}