package com.datastore.test.feature.shared.ui

import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.datastore.test.DatastoreApp
import com.datastore.test.R
import com.datastore.test.core.BaseFragment
import com.datastore.test.databinding.FragmentSharedPreferencesBinding
import javax.inject.Inject

class SharedPreferencesFragment : BaseFragment(R.layout.fragment_shared_preferences) {

    private val binding by viewBinding(FragmentSharedPreferencesBinding::bind)

    @Inject
    lateinit var viewModel: SharedPreferencesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectComponents()
    }

    override fun initUI() = with(binding) {
        mbSearch.setOnClickListener {
            viewModel.saveNewSearch(query = searchView.query.toString())
        }
    }


    private fun injectComponents() {
        DatastoreApp.component()
            .sharedPreferencesComponentBuilder()
            .build()
            .inject(this)
    }
}