package com.codingwithmitch.food2forkkmm.datasource.network

import io.ktor.client.*
import io.ktor.client.engine.darwin.*
import io.ktor.client.engine.ios.*
import io.ktor.client.plugins.kotlinx.serializer.*
import kotlinx.serialization.json.Json

actual class KtorClientFactory {
    actual fun build(): HttpClient {
        return HttpClient(Darwin) {
            engine {
                configureRequest {
                    setAllowsCellularAccess(true)
                }
            }

            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true

                    }
                )
            }
        }
    }
}