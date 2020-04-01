package org.example.converter.github

import org.example.model.github.GitHubRepo
import org.example.response.github.GitHubRepoResponse

class GitHubRepoConverter {

    fun convertToGitHubRepoResponse(gitHubRepo: GitHubRepo): GitHubRepoResponse {
        val gitHubRepoResponse = GitHubRepoResponse()
        gitHubRepoResponse.id = gitHubRepo.id
        gitHubRepoResponse.name = gitHubRepo.name
        return gitHubRepoResponse
    }

}