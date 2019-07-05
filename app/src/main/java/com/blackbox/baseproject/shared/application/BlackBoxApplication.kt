package com.blackbox.baseproject.shared.application

import android.app.Application


class BlackBoxApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initDagger()

    }

    private fun initDagger() {
        DaggerAppComponent.builder().application(this).build()
    }
}