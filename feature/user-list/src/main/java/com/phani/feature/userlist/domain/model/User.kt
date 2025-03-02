package com.phani.feature.userlist.domain.model

data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val username: String,
    val imageUrl: String,
    val role: String
)