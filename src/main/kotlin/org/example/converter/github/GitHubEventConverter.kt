package org.example.converter.github

import org.example.model.github.GitHubEvent
import org.example.response.github.GitHubEventResponse

class GitHubEventConverter(
    private val gitHubActorConverter: GitHubActorConverter,
    private val gitHubRepoConverter: GitHubRepoConverter
) {

    fun convertToGitHubEventResponse(event: GitHubEvent): GitHubEventResponse {
        val gitHubEventResponse = GitHubEventResponse()
        val gitHubActorResponse = gitHubActorConverter.convertToGitHubActorResponse(event.gitHubActor!!)
        val gitHubRepoResponse = gitHubRepoConverter.convertToGitHubRepoResponse(event.gitHubRepo!!)
        gitHubEventResponse.type = event.type
        gitHubEventResponse.actor = gitHubActorResponse
        gitHubEventResponse.repo = gitHubRepoResponse
        return gitHubEventResponse
    }

}