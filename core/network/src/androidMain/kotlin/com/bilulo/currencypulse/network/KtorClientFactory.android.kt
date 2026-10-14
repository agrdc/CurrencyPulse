package com.bilulo.currencypulse.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO

actual fun createHttpClient(): HttpClient {
    return HttpClient(CIO) {
        engine {
            // CIO engine configuration for Android
        }
        configureHttpClientConfig()
    }
}