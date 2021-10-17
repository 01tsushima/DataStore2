package com.datastore.test.feature.migration_from_pref.ui

import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.datastore.test.DatastoreApp
import com.datastore.test.R
import com.datastore.test.core.base.BaseFragment
import com.datastore.test.databinding.FragmentMigrationFromSharedPreferencesBinding
import javax.inject.Inject

class MigrationFromSharedPreferencesFragment : BaseFragment(R.layout.fragment_migration_from_shared_preferences) {

    private val binding by viewBinding(FragmentMigrationFromSharedPreferencesBinding::bind)

    @Inject
    lateinit var viewModel: MigrationFromSharedPreferencesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectComponents()
    }

    private fun injectComponents() {
        DatastoreApp
            .component()
            .migrationFromSharedPreferencesBuilder()
            .build()
            .inject(this)
    }

    override fun initUI() = with(binding) {
        switchNotification.setOnCheckedChangeListener { _, isChecked ->
            viewModel.notification(subscribe = isChecked)
        }
    }

    override fun onBindStates() {

    }
}