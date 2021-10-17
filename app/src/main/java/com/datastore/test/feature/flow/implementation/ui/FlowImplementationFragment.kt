package com.datastore.test.feature.flow.implementation.ui

import by.kirich1409.viewbindingdelegate.viewBinding
import com.datastore.test.R
import com.datastore.test.core.base.BaseFragment
import com.datastore.test.databinding.FragmentFlowImplementationBinding

class FlowImplementationFragment: BaseFragment(R.layout.fragment_flow_implementation) {

    private val binding by viewBinding(FragmentFlowImplementationBinding::bind)

    override fun initUI()  = with(binding){
       mbLogin.setOnClickListener {

       }
    }
}