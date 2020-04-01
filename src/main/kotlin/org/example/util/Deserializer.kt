package org.example.util

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.example.model.response.GitHubFeedResponse
import org.example.model.response.GitHubUserResponse

class Deserializer {

    private val mapper = jacksonObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL)

    fun deserializeFeedFromEvents(eventsJSON: String): List<GitHubFeedResponse>? {
        return mapper.readValue(eventsJSON, object : TypeReference<List<GitHubFeedResponse>>() {})
    }

    fun deserializeUser(userJson: String): GitHubUserResponse? {
        return mapper.readValue(userJson, object : TypeReference<GitHubUserResponse>() {})
    }

}