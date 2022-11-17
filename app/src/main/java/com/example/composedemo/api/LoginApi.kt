package com.example.composedemo.api

import com.example.composedemo.beans.MainEntity
import com.example.composedemo.net.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LoginApi {
    // 和协程联用
    @GET("article/list/{page}/json")
    suspend fun goLogin(@Path("page") page: Int): Response<MainEntity>
}