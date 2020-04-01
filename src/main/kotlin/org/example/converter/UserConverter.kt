package org.example.converter

import org.example.model.response.RegisteredUserResponse
import org.example.model.User
import org.example.model.response.UserResponse

class UserConverter {

    fun convertToRegisteredUserResponse(user: User): RegisteredUserResponse {
        var registeredUserResponse = RegisteredUserResponse()
        registeredUserResponse.username = user.username
        registeredUserResponse.token = user.token
        return registeredUserResponse
    }

    fun convertTosUserResponse(user: User): UserResponse {
        var userResponse = UserResponse()
        userResponse.username = user.username
        return userResponse
    }
}