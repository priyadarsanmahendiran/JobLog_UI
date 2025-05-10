package com.joblog_ui.provider

import android.content.Context
import com.joblog_ui.BuildConfig
import com.joblog_ui.service.JoblogService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    fun getClient(context: Context): Retrofit {
        val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val token = TokenManager.getToken(context)
                val requestBuilder = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json")

                // Attach Authorization header if token exists
                token?.let {
                    requestBuilder.addHeader("Authorization", "Bearer $it")
                }

                chain.proceed(requestBuilder.build())
            }
            .build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

object JobLogClient {
    val joblogService: JoblogService by lazy {
        RetrofitClient.getClient().create(JoblogService::class.java)
    }
}
