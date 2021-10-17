package com.datastore.test.feature.shared.ui

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.datastore.test.DatastoreApp
import com.datastore.test.R
import com.datastore.test.core.base.BaseFragment
import com.datastore.test.databinding.FragmentSharedPreferencesBinding
import ru.surfstudio.android.easyadapter.EasyAdapter
import javax.inject.Inject

class SharedPreferencesFragment : BaseFragment(R.layout.fragment_shared_preferences) {

    private val binding by viewBinding(FragmentSharedPreferencesBinding::bind)

    @Inject
    lateinit var viewModel: SharedPreferencesViewModel

    private val tagsAdapter = EasyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectComponents()
    }

    override fun initUI() = with(binding) {
        mbSearch.setOnClickListener {
            viewModel.saveNewSearch(query = searchView.query.toString())
        }
        rvTags.adapter = EasyAdapter()
    }

    override fun onBindStates() = with(lifecycleScope) {

    }


    private fun injectComponents() {
        DatastoreApp.component()
            .sharedPreferencesComponentBuilder()
            .build()
            .inject(this)
    }
}