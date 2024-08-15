package org.mitmuzaffarpur.attendencemanagement.domain

import okhttp3.OkHttpClient
import org.mitmuzaffarpur.attendencemanagement.util.Constant.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

object RetrofitInstance {

    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(5000, TimeUnit.SECONDS)  // Connection timeout
            .readTimeout(5000, TimeUnit.SECONDS)     // Read timeout
            .writeTimeout(5000, TimeUnit.SECONDS)    // Write timeout
            .build()
    }

    // Retrofit instance using the customized OkHttpClient
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)  // Attach the customized OkHttpClient here
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api:APIService by lazy {
        retrofit.create(APIService::class.java )
    }

}