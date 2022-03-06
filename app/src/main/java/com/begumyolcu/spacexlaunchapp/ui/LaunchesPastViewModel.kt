package com.begumyolcu.spacexlaunchapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.apollographql.apollo3.exception.ApolloException
import com.begumyolcu.spacexlaunchapp.LaunchesPastListQuery
import com.begumyolcu.spacexlaunchapp.apolloClient
import kotlinx.coroutines.launch

class LaunchesPastViewModel : ViewModel() {
    private var _launchesPastList = MutableLiveData<List<LaunchesPastListQuery.LaunchesPast>>()
    val launchesPastList: LiveData<List<LaunchesPastListQuery.LaunchesPast>> = _launchesPastList

    init {
        getLaunchesPast()
    }

    private fun getLaunchesPast() {
        viewModelScope.launch {
            val response = try {
                apolloClient.query(LaunchesPastListQuery()).execute()
            } catch (e: ApolloException) {
                Log.d("LaunchesPastList", "Failure", e)
                null
            }

            val launches = response?.data?.launchesPast?.filterNotNull()

            if (launches != null && !response.hasErrors()) {
                _launchesPastList.value = launches!!
            }
        }

    }






}