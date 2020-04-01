package org.example.converter.github

import org.example.model.github.GitHubUser
import org.example.response.github.GitHubDetailsResponse
import org.example.response.github.GitHubUserResponse

class GitHubUserConverter {

    fun convertToGitHubUserResponse(gitHubUser: GitHubUser): GitHubUserResponse {
        val user = GitHubUserResponse()
        user.id = gitHubUser.id
        user.login = gitHubUser.login
        user.avatar = gitHubUser.avatar

        val details = GitHubDetailsResponse()
        details.publicGists = gitHubUser.gistsUrl
        details.publicRepos = gitHubUser.reposUrl
        details.followers = gitHubUser.followers
        details.following = gitHubUser.following
        user.details = details

        return user
    }

}