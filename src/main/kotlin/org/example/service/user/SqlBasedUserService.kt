package org.example.service.user

import org.example.model.User

class SqlBasedUserService : IUserService {
    override fun getUsers(): List<User> {
        TODO("Not yet implemented")
    }

    override fun register(username: String, password: String): User {
        TODO("Not yet implemented")
    }

    override fun login(username: String, password: String): User? {
        TODO("Not yet implemented")
    }

    override fun getConnectedUser(token: String): User? {
        TODO("Not yet implemented")
    }
}