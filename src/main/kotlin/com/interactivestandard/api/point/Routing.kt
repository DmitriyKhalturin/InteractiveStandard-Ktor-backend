package com.interactivestandard.api.point

import com.interactivestandard.api.point.stub.buildCustomPoints
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.pointRouting() {
    get("/api/test/points") {
        val count = call.request.queryParameters["count"]?.toIntOrNull()
        val response = buildCustomPoints()

        when {
            count == null -> call.response.status(HttpStatusCode.BadRequest)
            count > response.points.size -> call.response.status(HttpStatusCode.InternalServerError)
            else -> call.respond(response)
        }
    }
}
