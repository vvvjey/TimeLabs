package com.example.navigation.router

import android.app.Activity
import android.content.Intent
import dagger.hilt.android.EntryPointAccessors

fun Activity.navigateToRoute(
    addressClass: Class<out InAppRouterAddress>,
    stackDefaultIntent: List<Intent> = emptyList()
) {
    val entryPoint = EntryPointAccessors.fromApplication(
        applicationContext,
        RouterEntryPoint::class.java
    )
    entryPoint.routerManager().navigate(addressClass, this, stackDefaultIntent)
}

fun Activity.navigateToPath(
    deeplink: String,
    stackDefaultIntent: List<Intent> = emptyList()
) {
    val entryPoint = EntryPointAccessors.fromApplication(
        applicationContext,
        RouterEntryPoint::class.java
    )
    entryPoint.routerManager().navigateByPath(deeplink, this, stackDefaultIntent)
}

fun Activity.canNavigateToRoute(addressClass: Class<out InAppRouterAddress>): Boolean {
    val entryPoint = EntryPointAccessors.fromApplication(
        applicationContext,
        RouterEntryPoint::class.java
    )
    return entryPoint.routerManager().canHandle(addressClass)
}