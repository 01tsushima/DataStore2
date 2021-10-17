package com.datastore.test.core.extensions

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment
import com.datastore.test.R

fun FragmentActivity.lazyNavController(@IdRes resId: Int = R.id.nav_host) = lazyNotSynchronized {
    runCatching { (supportFragmentManager.findFragmentById(resId) as NavHostFragment).navController }.getOrNull()
        ?: throw IllegalArgumentException("${this::class.java.simpleName} does not use \"navController\"")
}
fun <T> lazyNotSynchronized(initializer: () -> T): Lazy<T> =
    lazy(LazyThreadSafetyMode.NONE, initializer)