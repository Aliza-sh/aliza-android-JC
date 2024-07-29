package com.aliza.alizaandroidJC

data class User(val name: String)

class UserRepository {

    private val users = mutableListOf(
        User("Alice"),
        User("Bob"),
        User("Charlie")
    )

    fun getUsers(): List<User> = users.toList()

    fun addUser(user: User): List<User> {
        users.add(user)
        return users.toList()
    }
}