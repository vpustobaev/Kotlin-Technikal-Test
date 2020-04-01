package org.example.converter.github

import org.example.model.github.GitHubActor
import org.example.response.github.GitHubActorResponse

class GitHubActorConverter {

    fun convertToGitHubActorResponse(gitHubActor: GitHubActor): GitHubActorResponse {
        val gitHubActorResponse = GitHubActorResponse()
        gitHubActorResponse.id = gitHubActor.id
        gitHubActorResponse.login = gitHubActor.login
        return gitHubActorResponse
    }

}