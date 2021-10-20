package com.datastore.test.feature

import by.kirich1409.viewbindingdelegate.viewBinding
import com.datastore.test.R
import com.datastore.test.core.base.BaseFragment
import com.datastore.test.databinding.FragmentMainBinding

class MainFragment : BaseFragment(R.layout.fragment_main) {

    private val binding by viewBinding(FragmentMainBinding::bind)

    override fun initUI() = with(binding) {
        mbProtoDatastore.setOnClickListener {
            navController.navigate(R.id.nav_shared_preferences)
        }

        mbFlowImplementation.setOnClickListener {
            navController.navigate(R.id.nav_flow_implementation)
        }

        mbMigrationFromShared.setOnClickListener {
            navController.navigate(R.id.nav_migration)
        }

        mbSecuredDatastore.setOnClickListener {
            navController.navigate(R.id.nav_secured_datastore)
        }
    }

    override fun onBindStates() {

    }
}