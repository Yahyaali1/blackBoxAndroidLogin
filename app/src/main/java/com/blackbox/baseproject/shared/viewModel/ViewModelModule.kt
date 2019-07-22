package com.blackbox.baseproject.shared.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.blackbox.baseproject.shared.application.AppScope
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    /**
     * Explanation to bind key word vs provides
     * https://proandroiddev.com/dagger-2-annotations-binds-contributesandroidinjector-a09e6a57758f
     */
    @Binds
    @AppScope
    abstract fun bindViewModelFactory (factory: InjectableViewModelFactory) : ViewModelProvider.Factory


    @Binds
    @IntoMap
    @ViewModelKey(EmptyViewModel::class)
    abstract fun bindEmptyViewModel(viewModel: EmptyViewModel) : ViewModel


}