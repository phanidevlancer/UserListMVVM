package com.phani.feature.userlist.data.repository

import com.phani.core.network.api.UserApiService
import com.phani.feature.userlist.data.mapper.UserMapper
import com.phani.feature.userlist.domain.model.User
import com.phani.feature.userlist.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiService: UserApiService,
    private val mapper: UserMapper
) : UserRepository {
    override fun getUsers(): Flow<List<User>> = flow {
        val response = apiService.getUsers()
        val user = mapper.mapToDomainModelList(response.users)
        emit(user)
    }
}