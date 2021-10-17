package com.datastore.test.di.activity

import com.datastore.test.di.application.ApplicationComponent
import com.datastore.test.di.application.ApplicationComponentProxy
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