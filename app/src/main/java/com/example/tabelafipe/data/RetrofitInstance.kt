package com.example.tabelafipe.data

import com.example.tabelafipe.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: FipeAPI by lazy {
        retrofit.create(FipeAPI::class.java)
    }
}