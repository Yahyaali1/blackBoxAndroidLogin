package com.blackbox.baseproject.shared.application


import com.blackbox.baseproject.shared.activities.ActivityBuilderModule
import com.blackbox.baseproject.shared.viewModel.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 *
 * We mark this interface with the @Component annotation.
 * And we define all the modules that can be injected.
 * Note that we provide AndroidSupportInjectionModule.class
 * here. This class was not created by us.
 * It is an internal class in Dagger 2.10.
 * Provides our activities and fragments with given module.
 *
 */
@Component(
    modules = [AndroidSupportInjectionModule::class,
        AppModule::class,
        ViewModelModule::class,
        ActivityBuilderModule::class,
        AndroidSupportInjectionModule::class]
)
interface AppComponent : AndroidInjector<BlackBoxApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BlackBoxApplication): Builder
        fun build(): AppComponent
    }
}