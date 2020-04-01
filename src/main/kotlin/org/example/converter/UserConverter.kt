package org.example.converter

import org.example.model.User
import org.example.response.RegisteredUserResponse
import org.example.response.UserResponse

class UserConverter {

    fun convertToRegisteredUserResponse(user: User): RegisteredUserResponse? {
        var registeredUserResponse = RegisteredUserResponse()
        registeredUserResponse.username = user.username
        registeredUserResponse.token = user.token
        return registeredUserResponse
    }

    fun convertTosUserResponse(user: User): UserResponse? {
        var userResponse = UserResponse()
        userResponse.username = user.username
        return userResponse
    }
}