package com.datastore.test

import android.app.Application
import com.datastore.test.di.application.ApplicationComponent
import com.datastore.test.di.application.DaggerApplicationComponent

class DatastoreApp : Application() {

    companion object {
        lateinit var application: DatastoreApp
            private set

        fun component(): ApplicationComponent =
            application.component
    }

    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        application = this
        component = DaggerApplicationComponent
            .builder()
            .context(this)
            .build()
    }
}