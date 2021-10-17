package com.datastore.test.feature.flow.implementation.di

import com.datastore.test.feature.flow.implementation.ui.FlowImplementationFragment
import dagger.Subcomponent

@Subcomponent(modules = [FlowImplementationModule::class]

)
interface FlowImplementationComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): FlowImplementationComponent
    }

    fun inject(fragment: FlowImplementationFragment)
}