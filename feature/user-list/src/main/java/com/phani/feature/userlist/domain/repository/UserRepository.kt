package com.phani.feature.userlist.domain.repository

import com.phani.feature.userlist.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUsers(): Flow<List<User>>
}