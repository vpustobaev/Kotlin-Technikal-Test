package org.example.service

import org.apache.commons.lang3.RandomStringUtils
import org.example.model.User

class UserService {

    private val users = ArrayList<User>()

    fun getUsers(): ArrayList<User> {
        return users
    }

    fun register(user: User) {
        user.token = generateToken()
        users.add(user)
    }

    fun login(username: String, password: String): User? {
        for (user in users) {
            if (user.username == username && user.password == password) {
                user.token = generateToken()
                return user
            }
        }
        return null
    }

    fun getConnectedUser(token: String): User? {
        for (user in users) {
            if (user.token == token) {
                return user
            }
        }
        //TODO When such token does not exist
        return null
    }

    private fun generateToken(): String {
        return RandomStringUtils.randomAlphabetic(10)
    }
}