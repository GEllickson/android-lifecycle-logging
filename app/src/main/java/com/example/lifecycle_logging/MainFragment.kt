package com.example.lifecycle_logging

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lifecycle_logging.databinding.FragmentMainBinding

class MainFragment : BaseFragment() {

    override val tagName: String
        get() = "StartingFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        log("onCreateView, SavedInstanceState: ${savedInstanceState != null}")
        val binding = FragmentMainBinding.inflate(inflater)
        // NOTE: normally you probably shouldn't do this...
        binding.mainActivity = activity as MainActivity
        return binding.root
    }
}