package com.blackbox.baseproject.shared.viewModel

import androidx.lifecycle.ViewModelProvider
import com.blackbox.baseproject.shared.application.AppScope
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    /**
     * Explanation to bind key word vs provides
     * https://proandroiddev.com/dagger-2-annotations-binds-contributesandroidinjector-a09e6a57758f
     */
    @Binds
    @AppScope
    abstract fun bindViewModelFactory ( factory: InjectableViewModelFactory) : ViewModelProvider.Factory

}