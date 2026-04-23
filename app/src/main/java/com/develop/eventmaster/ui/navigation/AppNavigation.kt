package com.develop.eventmaster.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room3.Room
import com.develop.eventmaster.data.local.AppDatabase
import com.develop.eventmaster.data.repository.CategoryRepository
import com.develop.eventmaster.data.repository.EventRepository
import com.develop.eventmaster.ui.screens.HomeScreen
import com.develop.eventmaster.ui.screens.addcategory.AddCategoryScreen
import com.develop.eventmaster.ui.screens.addevent.AddEventScreen
import com.develop.eventmaster.ui.screens.detail.DetailScreen
import com.develop.eventmaster.viewmodel.CategoryViewModel
import com.develop.eventmaster.viewmodel.EventViewModel

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val context = LocalContext.current

    val database = remember {

        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "event_master_db"
<<<<<<< HEAD
        ).build()
=======
        )
            .fallbackToDestructiveMigration(true)
            .build()
>>>>>>> 61f5555 (fix: dependencies)
    }

    val eventRepository = remember {
        EventRepository(database.eventDao())
    }

    val categoryRepository = remember {
        CategoryRepository(database.categoryDao())
    }

    val eventViewModel = remember {
<<<<<<< HEAD
        EventViewModel(eventRepository)
=======
        EventViewModel(
            repository = eventRepository,
            categoryRepository = categoryRepository
        )
>>>>>>> 61f5555 (fix: dependencies)
    }

    val categoryViewModel = remember {
        CategoryViewModel(categoryRepository)
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

<<<<<<< HEAD
        composable("${Routes.DETAIL}/{id}") {

            DetailScreen()
=======
        composable("${Routes.DETAIL}/{id}") { backStackEntry ->

            val id = backStackEntry.arguments
                ?.getString("id")
                ?.toIntOrNull() ?: 0

            DetailScreen(
                eventId = id,
                viewModel = eventViewModel
            )
>>>>>>> 61f5555 (fix: dependencies)
        }
    }
}