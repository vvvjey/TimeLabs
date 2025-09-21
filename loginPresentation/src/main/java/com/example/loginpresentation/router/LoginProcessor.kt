package com.example.loginpresentation.router

import android.app.Activity
import android.content.Intent
import com.example.loginpresentation.ui.LoginActivity
import com.example.navigation.router.RouterProcessor

const val PATH_LOGIN = "login"

class LoginProcessor : RouterProcessor {
    override val deeplink: String = PATH_LOGIN

    override fun execute(deeplink: String, activity: Activity, stackDefaultIntent: List<Intent>) {
        startActivities(
            activity = activity,
            destinationIntent = Intent(activity, LoginActivity::class.java),
            stackDefaultIntent = stackDefaultIntent
        )
    }
}