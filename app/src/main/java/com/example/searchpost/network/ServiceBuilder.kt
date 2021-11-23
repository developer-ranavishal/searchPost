package com.example.searchpost.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL="https://api.postalpincode.in/"
object ServiceBuilder  {

    //create okhttp client
    private val okHttp = OkHttpClient.Builder()

    //create Retrofit Builder
    private val builder = Retrofit.Builder().baseUrl(BASE_URL).
    addConverterFactory(GsonConverterFactory.create()).
            client(okHttp.build())

    //create Retrofit Instance
    private val retrofit = builder.build()

    fun <T> buildService(serviceType : Class<T>) : T{
      return retrofit.create(serviceType)
    }
}