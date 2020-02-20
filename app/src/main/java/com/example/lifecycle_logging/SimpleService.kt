package com.example.lifecycle_logging

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder

class SimpleService : Service() {

    override fun onCreate() {
        log("onCreate")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val isSticky = intent?.getBooleanExtra(EXTRA_STICKY, false) ?: false
        log("onStartCommand. Sticky: $isSticky")
        return if (isSticky) {
            START_STICKY
        } else {
            START_NOT_STICKY
        }
    }

    override fun onBind(intent: Intent): IBinder? {
        log("onBind")
        return null
    }

    override fun onDestroy() {
        log("onDestroy")
        super.onDestroy()
    }

    private fun log(message: String) {
        log("SimpleService", message)
    }

    companion object {

        private const val EXTRA_STICKY = "start_sticky"

        fun intent(context: Context, sticky: Boolean): Intent {
            val intent = Intent(context, SimpleService::class.java)
            if (sticky) {
                intent.putExtra(EXTRA_STICKY, true)
            }
            return intent
        }

    }
}
