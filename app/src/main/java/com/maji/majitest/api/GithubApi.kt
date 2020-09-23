package com.maji.majitest.api

import com.maji.majitest.model.DataBean
import retrofit2.Call
import retrofit2.http.GET

interface GithubApi{
    @GET("/")
    fun index():Call<DataBean>
}