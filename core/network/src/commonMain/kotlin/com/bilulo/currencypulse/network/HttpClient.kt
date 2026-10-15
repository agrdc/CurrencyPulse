package com.bilulo.currencypulse.network

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.plugins.HttpTimeout
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * Platform-agnostic HTTP client factory function.
 * Actual implementation is provided by platform-specific expect/actual declarations.
 */
expect fun createHttpClient(): HttpClient

/**
 * Common HTTP client configuration function.
 */
fun configureHttpClientConfig(): HttpClientConfig<*>.() -> Unit = {
    install(ContentNegotiation) {
        json(Json {
            ignoreUnknownKeys = true
        })
    }
    install(WebSockets)
    install(HttpTimeout) {
        requestTimeoutMillis = 30_000
        connectTimeoutMillis = 30_000
        socketTimeoutMillis = 30_000
    }
}