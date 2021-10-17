package com.datastore.test.core

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.datastore.test.R

abstract class BaseActivity(@LayoutRes layoutResourceId: Int, navControllerId: Int = R.id.nav_host) :
    AppCompatActivity(layoutResourceId) {

    protected val navController by lazyNavController(navControllerId)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUI()
    }

    /**
     * Here we may init UI components.
     * This method will be executed after parent [onCreate] method
     */
    protected abstract fun initUI()
}