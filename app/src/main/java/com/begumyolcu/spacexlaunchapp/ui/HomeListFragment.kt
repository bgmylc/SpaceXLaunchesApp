package com.begumyolcu.spacexlaunchapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.begumyolcu.spacexlaunchapp.R
import com.begumyolcu.spacexlaunchapp.databinding.FragmentHomeListBinding


class HomeListFragment : Fragment() {
    private lateinit var binding: FragmentHomeListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_list, container, false)
        return binding.root
    }

}