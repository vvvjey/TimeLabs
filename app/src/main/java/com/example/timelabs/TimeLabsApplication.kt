package com.example.timelabs

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TimeLabsApplication : Application() {
    // No manual router setup needed - Dagger handles everything automatically!
}