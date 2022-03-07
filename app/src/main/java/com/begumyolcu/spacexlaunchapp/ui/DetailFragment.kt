package com.begumyolcu.spacexlaunchapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.begumyolcu.spacexlaunchapp.R
import com.begumyolcu.spacexlaunchapp.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val viewModel by lazy { LaunchesPastViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        val bundle: DetailFragmentArgs by navArgs()
        val launchId = bundle.launchId

        viewModel.launchesPastList.observe(viewLifecycleOwner, {launches ->
            for (launch in launches){
                if (launch.id == launchId) {
                    binding.launch = launch
                    binding.textViewDetailLaunchDate.setText(resources.getString(R.string.launch_date, launch.launch_date_local))
                    binding.textViewDetailVideoLink.setText(resources.getString(R.string.video_link,
                        launch.links?.video_link ?: "Unavaliable"
                    ))
                }
            }
        })

        return binding.root
    }




}