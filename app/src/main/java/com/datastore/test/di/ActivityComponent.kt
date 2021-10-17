package com.datastore.test.di

import com.datastore.test.di.scope.PerActivity
import dagger.Component

@PerActivity
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent : ApplicationComponentProxy, ActivityComponentProxy {

    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: ApplicationComponent
        ): ActivityComponent
    }
}