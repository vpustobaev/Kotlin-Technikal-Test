package org.example.resources

import org.example.api.GitHubApi
import org.example.model.response.GitHubFeedResponse
import org.example.util.Deserializer
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("api/github/")
@Produces(MediaType.APPLICATION_JSON)
class GitHubResource(private val gitHubApi: GitHubApi, private val deserializer: Deserializer) {

    @GET
    @Path("feed/")
    fun getGitHubFeed(): List<GitHubFeedResponse> {

        val responseList = ArrayList<GitHubFeedResponse>()
        val events = gitHubApi.getGitHubEvents()
        val feeds = deserializer.deserializeFeedFromEvents(events)

        feeds?.forEach {
            val response = GitHubFeedResponse()
            response.type = it.type
            response.actor = it.actor
            response.repo = it.repo
            responseList.add(response)
        }

        return responseList
    }

    @GET
    @Path("users/{username}")
    fun getGitHubPublicUser(@PathParam("username") username: String): LinkedHashMap<String, Any?> {

        val response = LinkedHashMap<String, Any?>()
        val gitHubUser = gitHubApi.getGitHubUser(username)
        val user = deserializer.deserializeUser(gitHubUser)!!

        response += "id" to user.id
        response += "login" to user.login
        response += "avatar" to user.avatar

        val details = LinkedHashMap<String, Any?>()
        details += "public_repos" to user.publicRepos
        details += "public_gists" to user.publicGists
        details += "followers" to user.followers
        details += "following" to user.following
        response += "details" to details

        return response
    }


}