package com.datastore.test.di.scope

import javax.inject.Scope

/** Dependency injection scope with [android.app.Application] lifetime. */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerApplication
