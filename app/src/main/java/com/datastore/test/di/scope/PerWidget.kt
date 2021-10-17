package com.datastore.test.di.scope

import javax.inject.Scope

/**
 * Dependency injection scope with [com.devexperts.upstox.client.core.ui.widget.Widget] lifetime.
 *
 * It might be [android.app.Activity], [android.app.Fragment], [android.app.Dialog], etc.
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerWidget
