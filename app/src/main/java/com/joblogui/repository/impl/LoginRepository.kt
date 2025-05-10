package com.joblogui.repository.impl

import com.joblogui.provider.JobLogClient
import com.joblogui.repository.BaseRepository
import com.joblogui.repository.interfaces.ILoginRepository
import com.joblogui.requestmodel.auth.AuthRequest
import com.joblogui.responsemodel.ResponseWrapper
import com.joblogui.responsemodel.auth.AuthResponse
import okhttp3.ResponseBody

class LoginRepository : BaseRepository(), ILoginRepository {
    override suspend fun loginUser(
        authRequest: AuthRequest
    ): ResponseWrapper<AuthResponse> = safeApiCall {
        JobLogClient.getService().login(
            authRequest = authRequest
        )
    }

    override suspend fun registerUser(
        authRequest: AuthRequest
    ): ResponseWrapper<ResponseBody> = safeApiCall {
        JobLogClient.getService().register(
            authRequest = authRequest
        )
    }
}
