package org.example.response.github

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonPropertyOrder("public_repos", "public_gists", "followers", "following")
class GitHubDetailsResponse {

    @JsonProperty("public_repos")
    var publicRepos: String? = null

    @JsonProperty("public_gists")
    var publicGists: String? = null

    var followers: Int? = null
    var following: Int? = null

}