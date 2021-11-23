package com.example.searchpost.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.searchpost.network.PostOffice
import com.example.searchpost.network.PostOfficeApi
import com.example.searchpost.network.ServiceBuilder
import kotlinx.coroutines.CompletableJob
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PostOfficeViewModel : ViewModel() {

    private var _listOfPostOffice: MutableLiveData<List<PostOffice>> = MutableLiveData()
    val listOfPostOffice: LiveData<List<PostOffice>>
        get() = _listOfPostOffice

    fun getPostByPin(pinCode: Int) {
        viewModelScope.launch {
            val response =
                ServiceBuilder.buildService(PostOfficeApi::class.java).getPostByPinCode(pinCode)
            val postResponseBody = response.body()
            if (postResponseBody != null) {
                Log.d("post", "${postResponseBody[0].PostOffice}")
                _listOfPostOffice.value = postResponseBody[0].PostOffice
            } else
                Log.d("post", "empty body")
        }
    }

}