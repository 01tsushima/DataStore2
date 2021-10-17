package com.datastore.test.feature


import androidx.navigation.fragment.NavHostFragment
import com.datastore.test.R
import com.datastore.test.core.base.BaseActivity

class MainActivity : BaseActivity(R.layout.activity_main) {

    override fun initUI() {
        supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
    }
}