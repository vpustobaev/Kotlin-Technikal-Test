package org.example.resource

import org.example.converter.UserConverter
import org.example.response.RegisteredUserResponse
import org.example.response.UserResponse
import org.example.service.user.IUserService
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType.APPLICATION_JSON

@Path("api/users/")
@Produces(APPLICATION_JSON)
class UserResource(private val userService: IUserService, private val userConverter: UserConverter) {

    @GET
    fun getUsers(): List<UserResponse> {
        var result = ArrayList<UserResponse>()
        var users = userService.getUsers()
        users.forEach {
            var userResponse = userConverter.convertTosUserResponse(it)!!
            result.add(userResponse)
        }
        return result
    }

    @GET
    @Path("register/")
    fun register(
        @QueryParam("username") username: String,
        @QueryParam("password") password: String
    ): RegisteredUserResponse? {
        val user = userService.register(username, password)
        return if (user != null) userConverter.convertToRegisteredUserResponse(user) else null
    }

    @GET
    @Path("login/")
    fun login(
        @QueryParam("username") username: String,
        @QueryParam("password") password: String
    ): RegisteredUserResponse? {
        var user = userService.login(username, password)
        return if (user != null) userConverter.convertToRegisteredUserResponse(user) else null
    }

    @GET
    @Path("me/")
    fun getConnectedUser(@QueryParam("token") token: String): UserResponse? {
        var user = userService.getConnectedUser(token)
        return if (user != null) userConverter.convertTosUserResponse(user) else null
    }

}