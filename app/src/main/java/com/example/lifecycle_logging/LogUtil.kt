package com.example.lifecycle_logging

import android.util.Log


fun log(tag: String, message: String) {
    val logTag = "LifecycleLogging. $tag"
    Log.i(logTag, message)
}