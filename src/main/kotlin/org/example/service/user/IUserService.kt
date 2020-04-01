package org.example.service.user

import org.example.model.User

interface IUserService {

    fun getUsers(): List<User>

    fun register(username: String, password: String): User?

    fun login(username: String, password: String): User?

    fun getConnectedUser(token: String): User?

}