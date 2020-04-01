package org.example.model.github

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonPropertyOrder("id", "login")
class GitHubActor : BaseJsonEntity() {

    @get:JsonProperty("id")
    @set:JsonProperty("id")
    @JsonProperty("id")
    var id: Int? = null

    @get:JsonProperty("login")
    @set:JsonProperty("login")
    @JsonProperty("login")
    var login: String? = null

}