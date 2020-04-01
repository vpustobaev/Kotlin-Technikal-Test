package org.example.service.user

import org.apache.commons.lang3.RandomStringUtils
import org.example.model.User

class MemoryBasedUserService : IUserService {

    private val users = ArrayList<User>()

    override fun getUsers(): ArrayList<User> {
        return users
    }

    override fun register(username: String, password: String): User? {
        if (users.isNotEmpty()) {
            for (user in users) {
                if (user.username == username) {
                    return null
                }
            }
        }
        return addUser(username, password)
    }

    private fun addUser(username: String, password: String): User {
        var user = User(username, password)
        user.token = generateToken()
        users.add(user)
        return user
    }

    override fun login(username: String, password: String): User? {
        for (user in users) {
            if (user.username == username && user.password == password) {
                user.token = generateToken()
                return user
            }
        }
        return null
    }

    override fun getConnectedUser(token: String): User? {
        for (user in users) {
            if (user.token == token) {
                return user
            }
        }
        return null
    }

    private fun generateToken(): String {
        return RandomStringUtils.randomAlphabetic(10)
    }
}