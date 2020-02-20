package com.example.lifecycle_logging

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    abstract val tagName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        log("onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        log("onStart")
        super.onStart()
    }

    override fun onRestart() {
        log("onRestart")
        super.onRestart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        log("onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        log("onActivityResult")
        super.onActivityResult(requestCode, resultCode, data)
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