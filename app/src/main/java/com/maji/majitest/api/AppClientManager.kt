package com.maji.majitest.api

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppClientManager private constructor() {

    private var logging = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
        override fun log(message: String) {
            Log.i("interceptor msg", message)
        }
    })

    private val retrofit: Retrofit
    private val okHttpClient: OkHttpClient
  
    init {
        okHttpClient = OkHttpClient().newBuilder().addInterceptor(logging).build()
        retrofit = Retrofit.Builder()  
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)  
                .build()  
    }  
  
    companion object {  
        private val manager = AppClientManager()  
        val client: Retrofit  
            get() = manager.retrofit  
    }  
}