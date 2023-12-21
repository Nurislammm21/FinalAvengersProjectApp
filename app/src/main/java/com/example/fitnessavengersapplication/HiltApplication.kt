package com.example.fitnessavengersapplication

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
    // do not finish this part of code and do not connect
}