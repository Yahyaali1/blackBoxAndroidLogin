package com.blackbox.baseproject.shared.application


import com.blackbox.baseproject.shared.viewModel.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [AndroidSupportInjectionModule::class,
        AppModule::class,
    ViewModelModule::class])
interface AppComponent : AndroidInjector<BlackBoxApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BlackBoxApplication): Builder


        fun build(): AppComponent
    }
}