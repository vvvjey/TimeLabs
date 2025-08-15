package com.example.splashscreenpresentation.router

import android.app.Activity
import android.content.Intent
import com.example.navigation.router.RouterProcessor
import com.example.splashscreenpresentation.SplashScreenActivity

const val PATH_SPLASH_SCREEN = "splash_screen"

class SplashScreenProcessor : RouterProcessor {
    override val deeplink: String = PATH_SPLASH_SCREEN

    override fun execute(deeplink: String, activity: Activity, stackDefaultIntent: List<Intent>) {
        startActivities(
            activity = activity,
            destinationIntent = Intent(activity, SplashScreenActivity::class.java),
            stackDefaultIntent = stackDefaultIntent
        )
    }
}