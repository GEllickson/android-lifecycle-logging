package com.example.lifecycle_logging

import android.app.*
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat

class ForegroundService : Service() {

    override fun onCreate() {
        log("onCreate")
        super.onCreate()
        val notification = createNotification()
        startForeground(13, notification)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        log("onStartCommand")
        return START_NOT_STICKY
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
        log("ForegroundService", message)
    }

    private fun createNotification(): Notification {
        val channelId = "foreground_service"
        val channelName = "Foreground Service"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                setShowBadge(false)
            }
            val nm = getSystemService(NotificationManager::class.java)
            nm?.createNotificationChannel(notificationChannel)
        }

        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        }
        val pendingIntent =
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        return NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("My foreground service")
            .setContentText("My foreground service is running")
            .setColor(ContextCompat.getColor(this, R.color.colorPrimary))
            .setProgress(0, 0, true)
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()
    }
}
