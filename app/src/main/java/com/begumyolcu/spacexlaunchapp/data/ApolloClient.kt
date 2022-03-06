package com.begumyolcu.spacexlaunchapp

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import okhttp3.OkHttpClient

val okhttpClient = OkHttpClient.Builder().build()

val apolloClient = ApolloClient.Builder()
    .serverUrl("https://api.spacex.land/graphql/")
    .okHttpClient(okhttpClient)
    .build()

