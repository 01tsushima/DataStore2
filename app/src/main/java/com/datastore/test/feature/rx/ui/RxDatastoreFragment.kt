package com.datastore.test.feature.rx.ui

import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.datastore.test.DatastoreApp
import com.datastore.test.R
import com.datastore.test.core.base.BaseFragment
import com.datastore.test.databinding.FragmentRxDatastoreBinding
import javax.inject.Inject

class RxDatastoreFragment : BaseFragment(R.layout.fragment_rx_datastore) {

    private val binding by viewBinding(FragmentRxDatastoreBinding::bind)

    @Inject
    lateinit var viewModel: RxDatastoreViewModel

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

    override fun onBindStates() {
        viewModel.userData.subscribe {
            binding.textviewResult.text = it.toString()
        }
    }

    private fun injectComponents() {
        DatastoreApp.component()
            .rxDataStoreBuilder()
            .build()
            .inject(this)
    }
}