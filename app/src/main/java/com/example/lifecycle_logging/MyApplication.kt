package com.example.lifecycle_logging

import android.app.Application

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        log("Application", "onCreate")
    }

}