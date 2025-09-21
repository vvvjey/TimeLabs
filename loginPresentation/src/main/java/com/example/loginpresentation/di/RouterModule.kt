package com.example.loginpresentation.di

import com.example.loginpresentation.router.LoginAddress
import com.example.loginpresentation.router.LoginInAppRouterAddress
import com.example.loginpresentation.router.LoginProcessor
import com.example.loginpresentation.router.PATH_LOGIN
import com.example.navigation.router.RouterAddressPathKey
import com.example.navigation.router.RouterInAppAddressKey
import com.example.navigation.router.RouterProcessor
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
    @RouterAddressPathKey(LoginAddress::class)
    fun provideLoginAddress(): String = PATH_LOGIN

    @Singleton
    @Provides
    @IntoMap
    @RouterInAppAddressKey(LoginInAppRouterAddress::class)
    fun provideLoginProcessor(): RouterProcessor = LoginProcessor()
}
