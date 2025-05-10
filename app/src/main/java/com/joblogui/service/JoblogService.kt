package com.joblogui.service

import com.joblogui.requestmodel.auth.AuthRequest
import com.joblogui.responsemodel.auth.AuthResponse
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
