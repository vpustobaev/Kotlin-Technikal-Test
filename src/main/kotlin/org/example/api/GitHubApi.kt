package org.example.api

import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("api/github/")
@Produces(MediaType.APPLICATION_JSON)
class GitHubApi {

    private val host = "https://api.github.com/"
    private val acceptHeaderValue = "application/vnd.github.v3+json"

    fun getGitHubEvents(): String {
        return Given {
            baseUri(host)
            header("Accept", acceptHeaderValue)
        } When {
            get("/events")
        } Then {
            statusCode(200)
        } Extract {
            asString()
        }
    }

    fun getGitHubUser(username: String): String {
        return Given {
            baseUri(host)
            header("Accept", acceptHeaderValue)
        } When {
            get("/users/$username")
        } Then {
            statusCode(200)
        } Extract {
            asString()
        }
    }

}