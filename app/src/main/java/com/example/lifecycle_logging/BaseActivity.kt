package com.example.lifecycle_logging

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    abstract val tagName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        log("onCreate, , SavedInstanceState: ${savedInstanceState != null}")
        super.onCreate(savedInstanceState)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        log("onActivityResult")
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onRestart() {
        log("onRestart")
        super.onRestart()
    }

    override fun onStart() {
        log("onStart")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        log("onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        log("onRequestPermissionsResult")
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onResume() {
        log("onResume")
        super.onResume()
    }

    override fun onPause() {
        log("onPause")
        super.onPause()
    }

    override fun onStop() {
        log("onStop")
        super.onStop()
    }

    /**
     * From the docs in P: "If called, this method will occur after onStop() for applications
     * targeting platforms starting with Android P.
     *
     * For applications targeting earlier platform versions this method will occur
     * before onStop() and there are no guarantees about whether it will
     * occur before or after onPause()."
     */
    override fun onSaveInstanceState(outState: Bundle) {
        log("onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        log("onDestroy")
        super.onDestroy()
    }

    protected fun log(message: String) {
        log(tagName, message)
    }

}