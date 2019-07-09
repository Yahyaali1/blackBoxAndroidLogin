package com.blackbox.baseproject.shared.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.blackbox.baseproject.shared.viewModel.BaseViewModel
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

abstract class BaseActivity<T : BaseViewModel> : AppCompatActivity(), HasSupportFragmentInjector, LayoutSetup {

    @Inject
    lateinit var hasFragmentInjector: DispatchingAndroidInjector<androidx.fragment.app.Fragment>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var eventBus: EventBus

    protected lateinit var viewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        restoreBundleState(savedInstanceState)


        setContentView(getLayoutId())
        viewModel = initViewModel()
        setup()
    }

    override fun onStart() {
        super.onStart()
        eventBus.register(this)
    }

    override fun onStop() {
        super.onStop()
        eventBus.unregister(this)
    }
    override fun supportFragmentInjector(): AndroidInjector<androidx.fragment.app.Fragment> = hasFragmentInjector

    override fun restoreBundleState(savedInstanceState: Bundle?) {

    }

}



