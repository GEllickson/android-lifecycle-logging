package com.example.lifecycle_logging

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import kotlin.concurrent.thread

class SimpleReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        log("onReceive")
        val pendingResult = goAsync()
        thread {
            log("manually going Async for 1 second")
            Thread.sleep(1000L)
            log("Async finished. The receiver can now be garbage collected")
            pendingResult.finish()
        }
    }

    private fun log(message: String) {
        log("SimpleReceiver", message)
    }
}
