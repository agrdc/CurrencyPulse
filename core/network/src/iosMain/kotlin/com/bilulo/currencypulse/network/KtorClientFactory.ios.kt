package com.bilulo.currencypulse.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin

actual class KtorClientFactory {
    actual fun createClient(): HttpClient {
        return HttpClient(Darwin) {
            engine {
                // Darwin engine configuration for iOS
            }
            configureHttpClientConfig()
        }
    }
}