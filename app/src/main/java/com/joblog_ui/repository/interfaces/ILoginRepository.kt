package com.joblog_ui.repository.interfaces

import com.joblog_ui.requestmodel.auth.AuthRequest
import com.joblog_ui.responsemodel.ResponseWrapper
import com.joblog_ui.responsemodel.auth.AuthResponse
import okhttp3.ResponseBody

interface ILoginRepository {

    suspend fun loginUser(
        authRequest: AuthRequest
    ): ResponseWrapper<AuthResponse>

    suspend fun registerUser(
        authRequest: AuthRequest
    ): ResponseWrapper<ResponseBody>

}