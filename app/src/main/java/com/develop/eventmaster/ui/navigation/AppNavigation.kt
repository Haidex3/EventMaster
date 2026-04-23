package com.develop.eventmaster.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.develop.eventmaster.ui.screens.AddCategoryScreen
import com.develop.eventmaster.ui.screens.AddEventScreen
import com.develop.eventmaster.ui.screens.DetailScreen
import com.develop.eventmaster.ui.screens.HomeScreen
import com.develop.eventmaster.viewmodel.EventViewModel

@Composable
fun AppNavigation(viewModel: EventViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            HomeScreen(navController, viewModel)
        }

        composable("addCategory") {
            AddCategoryScreen(navController, viewModel)
        }

        composable("addEvent") {
            AddEventScreen(navController, viewModel)
        }

        composable("detail/{eventId}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("eventId")?.toInt() ?: 0
            DetailScreen(navController, viewModel, id)
        }
    }
}