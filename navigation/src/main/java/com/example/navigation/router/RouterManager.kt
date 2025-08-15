package com.example.navigation.router

import android.app.Activity
import android.content.Intent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RouterManager @Inject constructor(
    private val processors: Map<Class<out InAppRouterAddress>, @JvmSuppressWildcards RouterProcessor>,
    private val addressPaths: Map<Class<out RouterAddress>, @JvmSuppressWildcards String>
) {

    fun navigate(
        addressClass: Class<out InAppRouterAddress>,
        activity: Activity,
        stackDefaultIntent: List<Intent> = emptyList()
    ) {
        val processor = processors[addressClass]
            ?: throw IllegalArgumentException("No processor found for address: ${addressClass.simpleName}")

        processor.execute(processor.deeplink, activity, stackDefaultIntent)
    }

    fun navigateByPath(
        deeplink: String,
        activity: Activity,
        stackDefaultIntent: List<Intent> = emptyList()
    ) {
        val processor = processors.values.find { it.deeplink == deeplink }
            ?: throw IllegalArgumentException("No processor found for deeplink: $deeplink")

        processor.execute(deeplink, activity, stackDefaultIntent)
    }

    fun getAvailablePaths(): List<String> {
        return processors.values.map { it.deeplink }
    }

    fun canHandle(addressClass: Class<out InAppRouterAddress>): Boolean {
        return processors.containsKey(addressClass)
    }

    fun canHandlePath(deeplink: String): Boolean {
        return processors.values.any { it.deeplink == deeplink }
    }
}