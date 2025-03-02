package com.phani.userlistmvvm.navigation

sealed class Screen(val route: String) {

    data object UserList : Screen("user_list")

    data object UserDetails : Screen("user_details/{userId}") {
        fun createRoute(userId: String): String = "user_details/$userId"
        const val userIdArg = "userId"
    }
}
