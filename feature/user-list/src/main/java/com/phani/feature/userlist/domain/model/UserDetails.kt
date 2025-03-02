package com.phani.feature.userlist.domain.model

data class UserDetails(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val maidenName: String?,
    val age: Int,
    val gender: String,
    val email: String,
    val phone: String,
    val username: String,
    val imageUrl: String,
    val birthDate: String,
    val bloodGroup: String,
    val height: Double,
    val weight: Double,
    val eyeColor: String,
    val hair: Hair,
    val address: Address,
    val university: String,
    val company: Company,
    val role: String
)

data class Hair(
    val color: String,
    val type: String
)

data class Address(
    val streetAddress: String,
    val city: String,
    val state: String,
    val stateCode: String,
    val postalCode: String,
    val country: String,
    val coordinates: Coordinates
)

data class Coordinates(
    val latitude: Double,
    val longitude: Double
)

data class Company(
    val department: String,
    val name: String,
    val title: String,
    val address: Address
)