package com.phani.feature.userlist.domain.usecase

import com.phani.core.common.extension.asResult
import com.phani.core.common.utils.ResultWrapper
import com.phani.feature.userlist.domain.model.User
import com.phani.feature.userlist.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val repository: UserRepository) {
    operator fun invoke(): Flow<ResultWrapper<List<User>>> = repository.getUsers().asResult()
}