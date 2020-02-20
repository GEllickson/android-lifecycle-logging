package com.example.lifecycle_logging

import android.os.Bundle

class StackedTranslucentActivity : BaseActivity() {

    override val tagName: String
        get() = "StackedTranslucentActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stacked_translucent)
    }
}