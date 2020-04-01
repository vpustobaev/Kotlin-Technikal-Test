package org.example.response.github

import com.fasterxml.jackson.annotation.JsonProperty

class GitHubEventResponse {

    var type: String? = null

    @JsonProperty("actor")
    var actor: GitHubActorResponse? = null

    @JsonProperty("repo")
    var repo: GitHubRepoResponse? = null
}