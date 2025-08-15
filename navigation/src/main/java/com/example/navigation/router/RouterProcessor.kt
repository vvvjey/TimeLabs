package com.example.navigation.router

import android.app.Activity
import android.content.Intent

interface RouterProcessor {
    val deeplink: String
    fun execute(deeplink: String, activity: Activity, stackDefaultIntent: List<Intent> = emptyList())

    fun startActivities(
        activity: Activity,
        destinationIntent: Intent,
        stackDefaultIntent: List<Intent> = emptyList()
    ) {
        val intents = stackDefaultIntent + destinationIntent
        activity.startActivities(intents.toTypedArray())
        activity.finish()
    }
}