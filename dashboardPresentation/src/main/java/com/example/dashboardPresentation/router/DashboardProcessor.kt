package com.example.dashboardPresentation.router

import android.app.Activity
import android.content.Intent
import com.example.dashboardPresentation.ui.DashboardActivity
import com.example.navigation.router.RouterProcessor

const val PATH_DASHBOARD = "dashboard"

class DashboardProcessor : RouterProcessor {
    override val deeplink: String = PATH_DASHBOARD

    override fun execute(deeplink: String, activity: Activity, stackDefaultIntent: List<Intent>) {
        startActivities(
            activity = activity,
            destinationIntent = Intent(activity, DashboardActivity::class.java),
            stackDefaultIntent = stackDefaultIntent
        )
    }
}