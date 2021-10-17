package com.datastore.test.core.base

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

abstract class BaseFragment(@LayoutRes private val layoutResourceId: Int) : Fragment(layoutResourceId) {

    protected val navController by lazy { findNavController() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }


    // TODO implement using @callbackFlow
    protected fun attachBackPressCallback(enabled: Boolean = true, action: OnBackPressedCallback.() -> Unit) =
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(enabled) {
                override fun handleOnBackPressed() = action(this)
            })

    /**
     * Here we may init UI components.
     * This method will be executed after parent [onCreateView] method
     */
    protected abstract fun initUI()

}