package com.develop.eventmaster.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.develop.eventmaster.data.remote.RetrofitClient
import com.develop.eventmaster.data.remote.repository.CategoryRepository
import com.develop.eventmaster.data.remote.repository.EventRepository
import com.develop.eventmaster.ui.screens.HomeScreen
import com.develop.eventmaster.ui.screens.addcategory.AddCategoryScreen
import com.develop.eventmaster.ui.screens.addevent.AddEventScreen
import com.develop.eventmaster.ui.screens.detail.DetailScreen
import com.develop.eventmaster.viewmodel.CategoryViewModel
import com.develop.eventmaster.viewmodel.EventViewModel

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val categoryRepository = remember {
        CategoryRepository(RetrofitClient.api)
    }

    val eventRepository = remember {
        EventRepository(RetrofitClient.api)
    }

    val categoryViewModel = remember {
        CategoryViewModel(categoryRepository)
    }

    val eventViewModel = remember {
        EventViewModel(
            repository = eventRepository,
            categoryRepository = categoryRepository
        )
    }

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {

        composable(Routes.HOME) {

            HomeScreen(
                navController = navController,
                viewModel = eventViewModel
            )
        }

        composable(Routes.ADD_CATEGORY) {

            AddCategoryScreen(
                navController = navController,
                viewModel = categoryViewModel
            )
        }

        composable(Routes.ADD_EVENT) {

            AddEventScreen(
                navController = navController,
                viewModel = eventViewModel
            )
        }

        composable("${Routes.DETAIL}/{id}") { backStackEntry ->

            val id = backStackEntry.arguments
                ?.getString("id")
                ?.toIntOrNull()
                ?: 0

            DetailScreen(
                eventId = id,
                viewModel = eventViewModel
            )
        }
    }
}