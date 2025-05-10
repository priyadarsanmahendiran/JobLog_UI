package com.joblog_ui.repository.impl

import com.joblog_ui.provider.JobLogClient
import com.joblog_ui.repository.BaseRepository
import com.joblog_ui.repository.interfaces.ILoginRepository
import com.joblog_ui.requestmodel.auth.AuthRequest
import com.joblog_ui.responsemodel.ResponseWrapper
import com.joblog_ui.responsemodel.auth.AuthResponse
import okhttp3.ResponseBody

class LoginRepository: BaseRepository(), ILoginRepository {
    override suspend fun loginUser(
        authRequest: AuthRequest
    ): ResponseWrapper<AuthResponse> = safeApiCall {
        JobLogClient.joblogService.login(
            authRequest = authRequest
        )
    }

    override suspend fun registerUser(
        authRequest: AuthRequest
    ): ResponseWrapper<ResponseBody> = safeApiCall {
        JobLogClient.joblogService.register(
            authRequest = authRequest
        )
    }
}