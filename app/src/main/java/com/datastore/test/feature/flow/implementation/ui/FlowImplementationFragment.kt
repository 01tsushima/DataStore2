package com.datastore.test.feature.flow.implementation.ui

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.datastore.test.DatastoreApp
import com.datastore.test.R
import com.datastore.test.core.base.BaseFragment
import com.datastore.test.core.observe
import com.datastore.test.databinding.FragmentFlowImplementationBinding
import javax.inject.Inject

class FlowImplementationFragment : BaseFragment(R.layout.fragment_flow_implementation) {

    private val binding by viewBinding(FragmentFlowImplementationBinding::bind)

    @Inject
    lateinit var viewModel: FlowImplementationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectComponents()
    }

    override fun initUI() = with(binding) {
        mbLogin.setOnClickListener {
            viewModel.login(editLogin.text.toString(), editPassword.text.toString())
        }
    }

    override fun onBindStates() = with(lifecycleScope) {
        observe(viewModel.showTokenFlow) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        }
    }


    private fun injectComponents() {
        DatastoreApp
            .component()
            .flowImplementationBuilder()
            .build()
            .inject(this)
    }

}