package com.joblogui.repository.interfaces

import com.joblogui.requestmodel.auth.AuthRequest
import com.joblogui.responsemodel.ResponseWrapper
import com.joblogui.responsemodel.auth.AuthResponse
import okhttp3.ResponseBody

interface ILoginRepository {

    suspend fun loginUser(
        authRequest: AuthRequest
    ): ResponseWrapper<AuthResponse>

    suspend fun registerUser(
        authRequest: AuthRequest
    ): ResponseWrapper<ResponseBody>
}
