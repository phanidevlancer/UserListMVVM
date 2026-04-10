package com.phani.feature.userlist.presentation

import com.phani.feature.userlist.domain.model.User

data class UserListState(
    val users: List<User> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)