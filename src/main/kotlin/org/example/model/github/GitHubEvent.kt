package org.example.model.github

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonPropertyOrder("type", "actor", "repo")
class GitHubEvent : BaseJsonEntity() {

    @get:JsonProperty("type")
    @set:JsonProperty("type")
    @JsonProperty("type")
    var type: String? = null

    @get:JsonProperty("actor")
    @set:JsonProperty("actor")
    @JsonProperty("actor")
    var gitHubActor: GitHubActor? = null

    @get:JsonProperty("repo")
    @set:JsonProperty("repo")
    @JsonProperty("repo")
    var gitHubRepo: GitHubRepo? = null

}