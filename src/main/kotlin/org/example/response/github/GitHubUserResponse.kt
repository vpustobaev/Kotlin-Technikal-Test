package org.example.response.github

import com.fasterxml.jackson.annotation.JsonProperty

class GitHubUserResponse {

    var id: Int? = null
    var login: String? = null
    var avatar: String? = null

    @JsonProperty("details")
    var details: GitHubDetailsResponse? = null

}