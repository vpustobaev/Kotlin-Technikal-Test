package org.example.model.github

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonPropertyOrder("id", "login", "avatar_url", "gists_url", "repos_url", "followers", "following")
class GitHubUser : BaseJsonEntity() {

    @get:JsonProperty("id")
    @set:JsonProperty("id")
    @JsonProperty("id")
    var id: Int? = null

    @get:JsonProperty("login")
    @set:JsonProperty("login")
    @JsonProperty("login")
    var login: String? = null

    @get:JsonProperty("avatar_url")
    @set:JsonProperty("avatar_url")
    @JsonProperty("avatar_url")
    var avatar: String? = null

    @get:JsonProperty("gists_url")
    @set:JsonProperty("gists_url")
    @JsonProperty("gists_url")
    var gistsUrl: String? = null

    @get:JsonProperty("repos_url")
    @set:JsonProperty("repos_url")
    @JsonProperty("repos_url")
    var reposUrl: String? = null

    @get:JsonProperty("followers")
    @set:JsonProperty("followers")
    @JsonProperty("followers")
    var followers: Int? = null

    @get:JsonProperty("following")
    @set:JsonProperty("following")
    @JsonProperty("following")
    var following: Int? = null

}