package com.interactivestandard.api

import com.interactivestandard.api.point.stub.buildCustomPoints
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.testing.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {

    companion object {
        private inline fun factoryTest(crossinline block: suspend ApplicationTestBuilder.() -> Unit) {
            testApplication {
                application {
                    install(ContentNegotiation) {
                        json()
                    }

                    configureRouting()
                }

                block()
            }
        }
    }

    @Test
    fun testRoot() {
        factoryTest {
            client.get("/").apply {
                assertEquals(HttpStatusCode.OK, status)
                assertEquals("Hello World!", bodyAsText())
            }
        }

    }

    @Test
    fun testPoints() {
        factoryTest {
            val points = buildCustomPoints()
            val count = points.points.size.minus(1)
            val responseContent = Json.encodeToString(points)

            client.get("/api/test/points?count=$count").apply {
                assertEquals(HttpStatusCode.OK, status)
                assertEquals(responseContent, bodyAsText())
            }

            client.get("/api/test/points").apply {
                assertEquals(HttpStatusCode.BadRequest, status)
            }

            client.get("/api/test/points?count=10").apply {
                assertEquals(HttpStatusCode.InternalServerError, status)
            }
        }
    }
}
