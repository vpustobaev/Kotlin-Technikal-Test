package org.example.model.response

import com.fasterxml.jackson.annotation.*

@JsonPropertyOrder("login", "id", "avatar_url", "gists_url", "repos_url", "followers", "following")
class GitHubUserResponse {

    var login: String? = null
    var id: Long? = null

    @JsonProperty("avatar_url")
    var avatar: String? = null

    @JsonProperty("gists_url")
    var publicGists: String? = null

    @JsonProperty("repos_url")
    var publicRepos: String? = null

    var followers: Int? = null
    var following: Int? = null

    @JsonIgnore
    private val additionalProperties: MutableMap<String, Any?> =
        HashMap()

    @JsonAnyGetter
    fun getAdditionalProperties(): Map<String, Any?> {
        return additionalProperties
    }

    @JsonAnySetter
    fun setAdditionalProperty(name: String, value: Any?) {
        additionalProperties[name] = value
    }
}