package com.blackbox.baseproject.shared.application


import android.app.Application
import com.blackbox.baseproject.shared.activities.ActivityBuilderModule
import com.blackbox.baseproject.shared.broadcastReceivers.BroadcastReceiverModule
import com.blackbox.baseproject.shared.fragments.FragmentBuilderModule
import com.blackbox.baseproject.shared.services.ServiceBuilderModule
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
@AppScope
@Component(
    modules = [AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilderModule::class,
        ViewModelModule::class,
        ServiceBuilderModule::class,
        BroadcastReceiverModule::class,
        FragmentBuilderModule::class]
)
interface AppComponent : AndroidInjector<BlackBoxApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}