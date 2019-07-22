package com.blackbox.baseproject.shared.application

import android.app.Activity
import android.app.Application
import android.app.Service
import android.content.BroadcastReceiver
import dagger.android.*
import javax.inject.Inject


class BlackBoxApplication : Application(), HasActivityInjector, HasBroadcastReceiverInjector, HasServiceInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var dispatchingServiceInjector: DispatchingAndroidInjector<Service>

    @Inject
    lateinit var dispatchingBroadcastReceiverInjector: DispatchingAndroidInjector<BroadcastReceiver>


    override fun serviceInjector(): AndroidInjector<Service> = dispatchingServiceInjector
    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector
    override fun broadcastReceiverInjector(): AndroidInjector<BroadcastReceiver> = dispatchingBroadcastReceiverInjector

    override fun onCreate() {
        super.onCreate()
        initDagger()

    }

    private fun initDagger() {
        DaggerAppComponent.builder().application(this).build()
    }
}