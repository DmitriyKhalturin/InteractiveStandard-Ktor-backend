package com.interactivestandard.api.point

import com.interactivestandard.api.point.response.Points
import com.interactivestandard.api.point.stub.buildCustomPoints
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.pointRouting() {
    get("/api/test/points") {
        val count = call.request.queryParameters["count"]?.toIntOrNull()
        val points = buildCustomPoints().points

        when {
            count == null -> call.response.status(HttpStatusCode.BadRequest)
            count > points.size -> call.response.status(HttpStatusCode.InternalServerError)
            else -> call.respond(Points(points = points.subList(0, count)))
        }
    }
}
