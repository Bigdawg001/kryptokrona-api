package org.kryptokrona.api.routes;

import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.kryptokrona.api.module
import kotlin.test.Test
import kotlin.test.assertEquals

class BlockRoutesTest {

    @Test
    fun blockRouteTest() = testApplication {
        application {
            module()
        }
        client.get("/v1/blocks").apply {
            assertEquals(HttpStatusCode.OK, status)
        }
    }

}