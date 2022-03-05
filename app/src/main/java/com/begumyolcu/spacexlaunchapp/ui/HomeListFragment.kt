package com.begumyolcu.spacexlaunchapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.begumyolcu.spacexlaunchapp.LaunchesPastListQuery
import com.begumyolcu.spacexlaunchapp.R
import com.begumyolcu.spacexlaunchapp.apolloClient
import com.begumyolcu.spacexlaunchapp.databinding.FragmentHomeListBinding


class HomeListFragment : Fragment() {
    private lateinit var binding: FragmentHomeListBinding
    private val viewModel by lazy { LaunchesPastViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_list, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenResumed {
            val response = apolloClient.query(LaunchesPastListQuery()).execute()

            Log.d("LaunchList", "Success ${response.data}")
        }
    }

}