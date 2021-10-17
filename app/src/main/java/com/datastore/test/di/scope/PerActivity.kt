package com.datastore.test.di.scope

import javax.inject.Scope

/** Dependency injection scope with [android.app.Activity] lifetime. */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity
