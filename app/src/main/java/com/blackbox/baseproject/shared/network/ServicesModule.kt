package com.blackbox.baseproject.shared.network

import com.blackbox.baseproject.shared.application.AppScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module (includes = [NetworkModule::class])
class ServicesModule {
    /**
     * this is to help introduce modules that require retofit to build its services
     *
     */

//    @Provides
//    @AppScope
//    fun providesAuthService(retrofit: Retrofit): AuthService {
//        return retrofit.create(AuthService::class.java)
//    }
}