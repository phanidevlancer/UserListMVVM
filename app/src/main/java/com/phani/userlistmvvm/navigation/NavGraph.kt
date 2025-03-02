package com.phani.userlistmvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.phani.feature.userlist.presentation.UserListScreen


/**
 * Main navigation graph for the app
 */
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.UserList.route
    ) {
        // User List Screen
        composable(Screen.UserList.route) {
            UserListScreen(
                onUserClick = { userId ->
                    navController.navigate(Screen.UserDetails.createRoute(userId.toString()))
                }
            )
        }

        // User Details Screen
        composable(
            route = Screen.UserDetails.route,
            arguments = listOf(
                navArgument(Screen.UserDetails.userIdArg) {
                    type = NavType.IntType
                }
            )
        ) {
//            UserDetailsScreen(
//                onNavigateBack = {
//                    navController.popBackStack()
//                }
//            )
        }
    }
}