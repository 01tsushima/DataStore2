package com.datastore.test

import android.app.Application
import com.datastore.test.di.ApplicationComponent
import com.datastore.test.di.DaggerApplicationComponent

class DatastoreApp : Application() {

//    val applicationComponent: ApplicationComponent by lazy {
//        DaggerApplicationComponent.factory().create(applicationContext)
//    }

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