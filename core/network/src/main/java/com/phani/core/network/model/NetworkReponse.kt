package com.phani.core.network.model

import com.google.gson.annotations.SerializedName

data class NetworkUserResponse(
    @SerializedName("users") val users: List<NetworkUser>,
    @SerializedName("total") val total: Int,
    @SerializedName("skip") val skip: Int,
    @SerializedName("limit") val limit: Int
)

data class NetworkUser(
    @SerializedName("id") val id: Int,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("maidenName") val maidenName: String?,
    @SerializedName("age") val age: Int,
    @SerializedName("gender") val gender: String,
    @SerializedName("email") val email: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("username") val username: String,
    @SerializedName("image") val image: String,
    @SerializedName("birthDate") val birthDate: String,
    @SerializedName("bloodGroup") val bloodGroup: String,
    @SerializedName("height") val height: Double,
    @SerializedName("weight") val weight: Double,
    @SerializedName("eyeColor") val eyeColor: String,
    @SerializedName("hair") val hair: NetworkHair,
    @SerializedName("address") val address: NetworkAddress,
    @SerializedName("university") val university: String,
    @SerializedName("company") val company: NetworkCompany,
    @SerializedName("role") val role: String
)

data class NetworkHair(
    @SerializedName("color") val color: String,
    @SerializedName("type") val type: String
)

data class NetworkAddress(
    @SerializedName("address") val address: String,
    @SerializedName("city") val city: String,
    @SerializedName("state") val state: String,
    @SerializedName("stateCode") val stateCode: String,
    @SerializedName("postalCode") val postalCode: String,
    @SerializedName("coordinates") val coordinates: NetworkCoordinates,
    @SerializedName("country") val country: String
)

data class NetworkCoordinates(
    @SerializedName("lat") val lat: Double,
    @SerializedName("lng") val lng: Double
)

data class NetworkCompany(
    @SerializedName("department") val department: String,
    @SerializedName("name") val name: String,
    @SerializedName("title") val title: String,
    @SerializedName("address") val address: NetworkAddress
)
