package com.example.searchpost.network

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//https://api.postalpincode.in/pincode/{PINCODE}
//https://newsapi.org/v2/top-headlines?country=in&apiKey=3c7b584412f04fb6a72353208a012524


interface PostOfficeApi{
    @GET("pincode/{PINCODE}")
  suspend  fun getPostByPinCode(
        @Path("PINCODE")pinCode : Int
    ) : Response<PostOfficeInfo<ArrayList<PostOfficeInfoItem>>>
}


//object PostOfficeApiService {
//// make singleton retrofit object
//    private val retrofit = Retrofit.Builder().
//    addConverterFactory(GsonConverterFactory.create()).
//    baseUrl(BASE_URL).build()
//    val retrofitService: PostOfficeApi by lazy {
//        retrofit.create(PostOfficeApi::class.java)
//    }
//}