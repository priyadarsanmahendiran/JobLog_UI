package com.joblogui.provider

import android.content.Context
import com.joblogui.BuildConfig
import com.joblogui.service.JoblogService
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

    private lateinit var joblogService: JoblogService

    fun init(context: Context) {
        joblogService = RetrofitClient.getClient(context).create(JoblogService::class.java)
    }

    fun getService(): JoblogService {
        if (!::joblogService.isInitialized) {
            throw IllegalStateException("JobLogClient is not initialized. Call init(context) in Application class.")
        }
        return joblogService
    }
}
