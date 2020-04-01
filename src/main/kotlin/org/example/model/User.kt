package org.example.model

data class User(val username: String, val password: String) {

    var token: String = ""

}