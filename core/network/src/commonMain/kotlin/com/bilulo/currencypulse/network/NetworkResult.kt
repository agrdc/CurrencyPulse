package com.bilulo.currencypulse.network

/**
 * Generic network result wrapper.
 * This will be expanded based on actual API contract requirements.
 */
sealed class NetworkResult<out T> {
    data class Success<T>(val data: T) : NetworkResult<T>()
    data class Error(val error: NetworkError) : NetworkResult<Nothing>()
}

/**
 * Network error types.
 * This will be expanded based on actual error handling requirements.
 */
sealed class NetworkError {
    data class HttpError(val code: Int) : NetworkError()
    data class NoConnectionError : NetworkError()
    data class TimeoutError : NetworkError()
    data class SerializationError : NetworkError()
    data class UnknownError : NetworkError()
}