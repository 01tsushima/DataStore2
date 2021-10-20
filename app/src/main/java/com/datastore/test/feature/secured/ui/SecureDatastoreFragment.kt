package com.datastore.test.feature.secured.ui

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.datastore.test.DatastoreApp
import com.datastore.test.R
import com.datastore.test.core.base.BaseFragment
import com.datastore.test.core.extensions.observe
import com.datastore.test.databinding.FragmentSecuredDatastoreBinding
import javax.inject.Inject

class SecureDatastoreFragment : BaseFragment(R.layout.fragment_secured_datastore) {

    private val binding by viewBinding(FragmentSecuredDatastoreBinding::bind)

    @Inject
    lateinit var viewModel: SecureDatastoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectComponents()
    }

    override fun initUI() = with(binding) {
        binding.mbLogin.setOnClickListener {
            viewModel.saveUserData(
                editLogin.text.toString(),
                editPassword.text.toString()
            )
        }
    }

    override fun onBindStates() = with(lifecycleScope) {
        observe(viewModel.userData) {
            binding.textviewResult.text = it
        }
    }

    private fun injectComponents() {
        DatastoreApp.component()
            .secureDataStoreBuilder()
            .build()
            .inject(this)
    }
}