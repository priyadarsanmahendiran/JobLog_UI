package com.joblog_ui.service

import com.joblog_ui.requestmodel.auth.AuthRequest
import com.joblog_ui.responsemodel.auth.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface JoblogService {

    @POST("auth/login")
    suspend fun login(
        @Body authRequest: AuthRequest
    ): Response<AuthResponse>

    @POST("auth/register")
    suspend fun register(
        @Body authRequest: AuthRequest
    ): Response<ResponseBody>

}