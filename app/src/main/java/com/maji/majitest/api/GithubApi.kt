package com.maji.majitest.api

import com.maji.majitest.bean.DataBean
import retrofit2.Call
import retrofit2.http.GET

interface GithubApi{
    @GET("/")
    fun index():Call<DataBean>
}