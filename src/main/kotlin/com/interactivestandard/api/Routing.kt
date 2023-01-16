package com.interactivestandard.api

import com.interactivestandard.api.point.pointRouting
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    routing {
        pointRouting()

        // Use in Unit test.
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
