package com.example.lifecycle_logging

import android.Manifest
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity : BaseActivity() {

    override val tagName: String
        get() = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun launchActivity() {
        startActivity(Intent(this, StackedActivity::class.java))
    }

    fun translucentActivity() {
        startActivity(Intent(this, StackedTranslucentActivity::class.java))
    }

    fun replaceFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, NextFragment())
            .addToBackStack(null)
            .commit()
    }

    fun addFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, NextFragment())
            .addToBackStack(null)
            .commit()
    }

    fun showDialog() {
        AlertDialog.Builder(this).setTitle("Title")
            .setMessage("Body")
            .setPositiveButton("Close") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    fun startNewActivityForResult() {
        startActivityForResult(Intent(this, StackedActivity::class.java), 0)
    }

    fun requestPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.CAMERA), 0
        )
    }

    fun startNotStickyService() {
        startService(SimpleService.intent(this, false))
    }

    fun startStickyService() {
        startService(SimpleService.intent(this, true))
    }

    fun stopService() {
        stopService(Intent(this, SimpleService::class.java))
    }

    fun startForegroundService() {
        val intent = Intent(this, ForegroundService::class.java)
        ContextCompat.startForegroundService(this, intent)
    }

    fun stopForegroundService() {
        stopService(Intent(this, ForegroundService::class.java))
    }

    fun broadcastReceiver() {
        triggerAlarm(0)
    }

    fun delayedBroadcastReceiver() {
        triggerAlarm(10_000L)
    }

    private fun triggerAlarm(delayMillis: Long) {
        val am = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, SimpleReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            this,
            0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        val delay = System.currentTimeMillis() + delayMillis
        am.setExact(AlarmManager.RTC_WAKEUP, delay, pendingIntent)
    }

}
