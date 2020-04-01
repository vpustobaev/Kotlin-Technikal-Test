package org.example.service

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.example.model.github.GitHubEvent
import org.example.model.github.GitHubUser

class GitHubService {

    fun getGitHubEvents(): List<GitHubEvent> {
        return getEntities("/events", object : TypeReference<List<GitHubEvent>>() {})
    }

    fun getGitHubUser(username: String): GitHubUser {
        return getEntities("/users/$username", object : TypeReference<GitHubUser>() {})
    }

    private fun <T> getEntities(path: String, valueTypeRef: TypeReference<T>): T {
        var json = query(path)
        return transform(json, valueTypeRef)
    }

    private fun query(path: String): String {
        return Given {
            baseUri("https://api.github.com/") // can be made configurable
            header("Accept", "application/vnd.github.v3+json")
        } When {
            get(path)
        } Then {
            statusCode(200)
        } Extract {
            asString()
        }
    }

    private fun <T> transform(json: String, valueTypeRef: TypeReference<T>): T {
        var serializer = jacksonObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL)
        return serializer.readValue(json, valueTypeRef)
    }
}