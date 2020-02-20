package com.example.lifecycle_logging

import android.os.Bundle

class StackedActivity : BaseActivity() {

    override val tagName: String
        get() = "StackedActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stacked)
    }
}