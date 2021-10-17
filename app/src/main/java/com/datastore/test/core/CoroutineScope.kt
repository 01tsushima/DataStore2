package com.datastore.test.core

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

fun <T> LifecycleCoroutineScope.observe(flow: Flow<T>, action: (value: T) -> Unit) {
    launchWhenResumed {
        flow.collect { event ->
            action(event)
        }
    }
}