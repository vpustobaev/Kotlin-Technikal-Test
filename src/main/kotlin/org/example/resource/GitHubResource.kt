package org.example.resource

import org.example.converter.github.GitHubEventConverter
import org.example.converter.github.GitHubUserConverter
import org.example.response.github.GitHubEventResponse
import org.example.response.github.GitHubUserResponse
import org.example.service.GitHubService
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("api/github/")
@Produces(MediaType.APPLICATION_JSON)
class GitHubResource(
    private val gitHubService: GitHubService,
    private val gitHubEventConverter: GitHubEventConverter,
    private val gitHubUserConverter: GitHubUserConverter
) {

    @GET
    @Path("feed/")
    fun getGitHubFeed(): List<GitHubEventResponse> {
        val gitHubFeed = ArrayList<GitHubEventResponse>()
        val gitHubEvents = gitHubService.getGitHubEvents()
        for (item in gitHubEvents) {
            var feed = gitHubEventConverter.convertToGitHubEventResponse(item)
            gitHubFeed.add(feed)
        }

        return gitHubFeed
    }

    @GET
    @Path("users/{username}")
    fun getGitHubPublicUser(@PathParam("username") username: String): GitHubUserResponse {
        val gitHubUser = gitHubService.getGitHubUser(username)
        return gitHubUserConverter.convertToGitHubUserResponse(gitHubUser)
    }


}