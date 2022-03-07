package com.begumyolcu.spacexlaunchapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.begumyolcu.spacexlaunchapp.LaunchesPastListQuery
import com.begumyolcu.spacexlaunchapp.R
import com.begumyolcu.spacexlaunchapp.apolloClient
import com.begumyolcu.spacexlaunchapp.databinding.FragmentHomeListBinding


class HomeListFragment : Fragment() {
    private lateinit var binding: FragmentHomeListBinding
    private val viewModel by lazy { LaunchesPastViewModel() }
    private lateinit var adapter: LaunchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_list, container, false)

        binding.lifecycleOwner = this

        viewModel.launchesPastList.observe(viewLifecycleOwner, {launches ->
            adapter = LaunchAdapter(launches, this)
            binding.adapter = adapter
        })

        //TODO 1: Pagination eklenecek
        //TODO 2: Detay sayfaya geçilecek
        //TODO 3: Detay sayfa UI bağlantı
        //TODO 4: Saygınlık



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}