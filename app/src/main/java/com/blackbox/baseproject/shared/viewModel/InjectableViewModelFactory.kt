package com.blackbox.baseproject.shared.viewModel

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.blackbox.baseproject.shared.application.AppScope
import java.lang.IllegalStateException
import javax.inject.Inject
import javax.inject.Provider

@AppScope
class InjectableViewModelFactory @Inject constructor(
    private val viewModelProvider: Map<Class<out ViewModel>,Provider<View>>
):ViewModelProvider.Factory {

    /**
     *Now we need to inject these two modules into our ViewModel.
     * ViewModelFactory class basically helps you dynamically create ViewModels for your
     * Activities and Fragments. The ViewModelFactoryclass has a list of
     * providers and can create any ViewModel that was bound.
     */
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val provider = viewModelProvider[modelClass]

        provider?.let {
           return it.get() as T
        }?:run {
            throw IllegalStateException("No Provider could be found for given key")
        }
    }
}