package com.phani.core.network.api

import com.phani.core.network.model.NetworkUser
import com.phani.core.network.model.NetworkUserResponse
import com.phani.core.network.utils.NetworkConstants
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApiService {
    @GET(NetworkConstants.USERS_ENDPOINT)
    suspend fun getUsers() : NetworkUserResponse


    @GET(NetworkConstants.USER_ENDPOINT)
    suspend fun getUserById(@Path("userId") userId : Int) : NetworkUser
}