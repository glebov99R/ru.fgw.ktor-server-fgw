package ru.fgw.plugins

import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import ru.fgw.model.Test

fun Application.configureRouting() {

    routing {

        get("/text") {
            call.respond(Test(text = "kitty"))
        }

//        authenticate("auth-jwt"){
//            get("/hello") {
//                val principal = call.principal<JWTPrincipal>()
//                val username = principal!!.payload.getClaim("username").asString()
//                val expiresAt = principal.expiresAt?.time?.minus(System.currentTimeMillis())
//                call.respondText("Hello, $username! Token is expired at $expiresAt ms.")
//            }
//        }


    }

}
