package com.example.lifecycle_logging

import android.Manifest
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat


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

}
