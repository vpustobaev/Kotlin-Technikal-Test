package org.example.model.response

import com.fasterxml.jackson.annotation.*
import org.example.model.Actor
import org.example.model.Repo
import java.util.HashMap

@JsonPropertyOrder("type", "actor", "repo")
class GitHubFeedResponse {

    @get:JsonProperty("type")
    @set:JsonProperty("type")
    @JsonProperty("type")
    var type: String? = null

    @get:JsonProperty("actor")
    @set:JsonProperty("actor")
    @JsonProperty("actor")
    var actor: Actor? = null

    @get:JsonProperty("repo")
    @set:JsonProperty("repo")
    @JsonProperty("repo")
    var repo: Repo? = null

    @JsonIgnore
    private val additionalProperties: MutableMap<String, Any> =
        HashMap()

    @JsonAnyGetter
    fun getAdditionalProperties(): Map<String, Any> {
        return additionalProperties
    }

    @JsonAnySetter
    fun setAdditionalProperty(name: String, value: Any) {
        additionalProperties[name] = value
    }
}