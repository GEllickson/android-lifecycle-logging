package com.example.lifecycle_logging

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class NextFragment : BaseFragment() {

    override val tagName: String
        get() = "NextFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        log("onCreateView, , SavedInstanceState: ${savedInstanceState != null}")
        return inflater.inflate(R.layout.fragment_next, container, false)
    }
}