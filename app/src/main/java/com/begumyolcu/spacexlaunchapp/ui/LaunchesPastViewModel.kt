package com.begumyolcu.spacexlaunchapp.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.begumyolcu.spacexlaunchapp.LaunchesPastListQuery
import com.begumyolcu.spacexlaunchapp.apolloClient
import kotlinx.coroutines.launch

class LaunchesPastViewModel : ViewModel() {

    init {
        getLaunchesPast()
    }

    private fun getLaunchesPast() {
        viewModelScope.launch {
           val response = apolloClient.query(LaunchesPastListQuery()).execute()

            Log.e("LaunchesPastList", "Success ${response.data}")
        }

    }

}