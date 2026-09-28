package com.bilulo.currencypulse.network

/**
 * Generic API response wrapper.
 * This will be expanded based on actual API contract requirements.
 */
sealed class ApiResponse<out T> {
    data class Success<T>(val data: T) : ApiResponse<T>()
    data class Error(val error: NetworkError) : ApiResponse<Nothing>()
    object Loading : ApiResponse<Nothing>()
}

/**
 * Network error types.
 * This will be expanded based on actual error handling requirements.
 */
sealed class NetworkError {
    data class HttpError(val code: Int, val message: String) : NetworkError()
    data class NetworkException(val message: String) : NetworkError()
    data class SerializationError(val message: String) : NetworkError()
    data class UnknownError(val message: String) : NetworkError()
}