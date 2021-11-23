package com.example.searchpost.network

data class PostOfficeInfoItem(
    val Message: String,
    val PostOffice: List<PostOffice>,
    val Status: String
)