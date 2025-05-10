package com.joblogui.responsemodel

sealed class ResponseWrapper<T> {
    data class Success<T>(
        val data: T? = null,
        val httpCode: Int? = null
    ) : ResponseWrapper<T> ()

    data class Error<T>(
        val error: String? = null,
        val httpCode: Int? = null
    ) : ResponseWrapper<T> ()
}
