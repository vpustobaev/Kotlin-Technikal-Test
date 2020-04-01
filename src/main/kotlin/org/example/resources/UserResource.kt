package org.example.resources

import org.example.converter.UserConverter
import org.example.model.User
import org.example.model.response.RegisteredUserResponse
import org.example.model.response.UserResponse
import org.example.service.UserService
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType.APPLICATION_JSON

@Path("api/users/")
@Produces(APPLICATION_JSON)
class UserResource(private val userService: UserService, private val userConverter: UserConverter) {

    @GET
    fun getUsers(): List<UserResponse> {
        var result = ArrayList<UserResponse>()
        var users = userService.getUsers()
        users.forEach {
            var userResponse = userConverter.convertTosUserResponse(it)
            result.add(userResponse)
        }
        return result
    }

    @GET
    @Path("register/")
    fun register(
        @QueryParam("username") username: String,
        @QueryParam("password") password: String
    ): RegisteredUserResponse {
        var user = User(username, password)
        userService.register(user)
        return userConverter.convertToRegisteredUserResponse(user)
    }

    @GET
    @Path("login/")
    fun login(
        @QueryParam("username") username: String,
        @QueryParam("password") password: String
    ): RegisteredUserResponse {
        var user = userService.login(username, password)!!
        return userConverter.convertToRegisteredUserResponse(user)
    }

    @GET
    @Path("me/")
    fun getConnectedUser(@QueryParam("token") token: String): UserResponse {
        var user = userService.getConnectedUser(token)!!
        return userConverter.convertTosUserResponse(user)
    }

}