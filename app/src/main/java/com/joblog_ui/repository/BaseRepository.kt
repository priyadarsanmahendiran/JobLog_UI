package com.joblog_ui.repository

import com.joblog_ui.responsemodel.ResponseWrapper
import retrofit2.Response

open class BaseRepository {

    suspend fun <T: Any> safeApiCall(
        apiCall: suspend () -> Response<T>
    ): ResponseWrapper<T> {
        val responseWrapper: ResponseWrapper<T>
        return try {
            val response: Response<T> = apiCall.invoke()
            responseWrapper = if(response.isSuccessful){
                val body = response.body()
                if (body != null) {
                    ResponseWrapper.Success(body, response.code())
                } else {
                    ResponseWrapper.Error("Response body is null", response.code())
                }
            } else {
                ResponseWrapper.Error(response.message(), response.code())
            }
            return responseWrapper
        } catch (e: Exception) {
            ResponseWrapper.Error(e.message)
        }
    }

}