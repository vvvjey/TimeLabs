package com.example.navigation.router

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface RouterEntryPoint {
    fun routerManager(): RouterManager
}