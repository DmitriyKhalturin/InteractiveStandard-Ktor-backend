package com.interactivestandard.api

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*

fun main() {
    embeddedServer(
        factory = Netty,
        port = Config.port,
        host = Config.host,
        module = {
            install(ContentNegotiation) {
                json()
            }

            configureRouting()
        },
    ).start(wait = true)
}
