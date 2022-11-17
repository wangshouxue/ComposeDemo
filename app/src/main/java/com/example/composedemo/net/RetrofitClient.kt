package com.example.composedemo.net

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private var mRetrofit: Retrofit? = null
    private const val CONNECTION_TIME_OUT = 10L
    private const val READ_TIME_OUT = 10L
    private var Base_URL = "https://www.wanandroid.com"

    fun getRetrofit(): Retrofit {
        if (mRetrofit == null) {
            synchronized(this) {
                if (mRetrofit == null) {
                    val okHttpClient = buildOkHttpClient()
                    mRetrofit = buildRetrofit(Base_URL, okHttpClient )
                }
            }
        }
        return mRetrofit!!
    }

    private fun buildOkHttpClient(): OkHttpClient.Builder {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
            .proxy( java.net.Proxy.NO_PROXY)
    }

    private fun buildRetrofit(baseUrl: String, builder: OkHttpClient.Builder): Retrofit {
        val client = builder.build()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client).build()
    }

}