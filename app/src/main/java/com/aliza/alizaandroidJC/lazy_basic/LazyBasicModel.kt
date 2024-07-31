package com.aliza.alizaandroidJC.lazy_basic

import androidx.compose.ui.graphics.Color

data class User(
    val name: String,
    val rank: Int,
    val color: Color
)

class UserRepository {

    fun getTopUsers(): List<User> = topUsers.toList()
    fun getUsers(): List<User> = otherUsers.toList()

}