package com.example.navigation.router

import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class RouterAddressPathKey(val value: KClass<out RouterAddress>)

@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class RouterInAppAddressKey(val value: KClass<out InAppRouterAddress>)