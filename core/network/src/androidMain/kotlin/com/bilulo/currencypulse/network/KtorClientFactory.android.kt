package com.bilulo.currencypulse.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO

actual class KtorClientFactory {
    actual fun createClient(): HttpClient {
        return HttpClient(CIO) {
            engine {
                // CIO engine configuration for Android
            }
            configureHttpClientConfig()
        }
    }
}