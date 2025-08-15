package com.example.splashscreenpresentation.di

import com.example.navigation.router.RouterAddressPathKey
import com.example.navigation.router.RouterInAppAddressKey
import com.example.navigation.router.RouterProcessor
import com.example.splashscreenpresentation.router.PATH_SPLASH_SCREEN
import com.example.splashscreenpresentation.router.SplashScreenAddress
import com.example.splashscreenpresentation.router.SplashScreenInAppRouterAddress
import com.example.splashscreenpresentation.router.SplashScreenProcessor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RouterModule {

    @Singleton
    @Provides
    @IntoMap
    @RouterAddressPathKey(SplashScreenAddress::class)
    fun provideSplashScreenAddress(): String = PATH_SPLASH_SCREEN

    @Singleton
    @Provides
    @IntoMap
    @RouterInAppAddressKey(SplashScreenInAppRouterAddress::class)
    fun provideSplashScreenProcessor(): RouterProcessor = SplashScreenProcessor()
}