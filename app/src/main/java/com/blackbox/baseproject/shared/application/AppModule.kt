package com.blackbox.baseproject.shared.application

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import org.greenrobot.eventbus.EventBus

@Module
class AppModule {
    @Provides
    fun providesContext(application: Application):Context{
        return application.applicationContext
    }

    @Provides
    fun providesEventBus(): EventBus {
        return EventBus.getDefault()
    }
}