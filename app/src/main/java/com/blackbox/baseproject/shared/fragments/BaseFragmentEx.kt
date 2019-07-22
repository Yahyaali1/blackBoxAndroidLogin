package com.blackbox.baseproject.shared.fragments

import androidx.lifecycle.ViewModelProviders
import com.blackbox.baseproject.shared.activities.getViewModelClass
import com.blackbox.baseproject.shared.viewModel.BaseViewModel

fun <T : BaseViewModel> BaseFragment<T>.initViewModel(): T {
    return initViewModel(getViewModelClass(javaClass))
}

fun <T : BaseViewModel> BaseFragment<*>.initViewModel(clazz: Class<T>): T {
    return ViewModelProviders.of(this, viewModelFactory).get(clazz).also {
        lifecycle.addObserver(it)
    }
}