package com.example.dashboardPresentation.di

import com.example.dashboardPresentation.router.DashboardAddress
import com.example.dashboardPresentation.router.DashboardInAppRouterAddress
import com.example.dashboardPresentation.router.DashboardProcessor
import com.example.dashboardPresentation.router.PATH_DASHBOARD
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
    @RouterAddressPathKey(DashboardAddress::class)
    fun provideDashboardAddress(): String = PATH_DASHBOARD

    @Singleton
    @Provides
    @IntoMap
    @RouterInAppAddressKey(DashboardInAppRouterAddress::class)
    fun provideDashboardProcessor(): RouterProcessor = DashboardProcessor()
}
