package com.phani.feature.userlist.data.mapper

import com.phani.core.network.model.NetworkUser
import com.phani.feature.userlist.domain.model.User
import javax.inject.Inject

class UserMapper @Inject constructor() {

    fun mapToDomainModel(networkUser: NetworkUser): User {
        return User(
            id = networkUser.id,
            firstName = networkUser.firstName,
            lastName = networkUser.lastName,
            email = networkUser.email,
            username = networkUser.username,
            imageUrl = networkUser.image,
            role = networkUser.role
        )
    }

    fun mapToDomainModelList(networkUsers: List<NetworkUser>): List<User> {
        return networkUsers.map { mapToDomainModel(it) }
    }
}