package com.develop.eventmaster.ui.screens

<<<<<<< HEAD
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
=======
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
>>>>>>> 61f5555 (fix: dependencies)
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
<<<<<<< HEAD
=======
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
>>>>>>> 61f5555 (fix: dependencies)
import androidx.navigation.NavController
import com.develop.eventmaster.ui.components.EmptyState
import com.develop.eventmaster.ui.components.EventCard
import com.develop.eventmaster.ui.navigation.Routes
import com.develop.eventmaster.viewmodel.EventViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: EventViewModel
) {

    val events by viewModel.events.collectAsState()
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
    val categories by viewModel.categories.collectAsState()
>>>>>>> 8ed41c6 (fix: view)

    val groupedEvents = events.groupBy { it.categoryId }
>>>>>>> 61f5555 (fix: dependencies)

    Scaffold(
        floatingActionButton = {
<<<<<<< HEAD
<<<<<<< HEAD

            FloatingActionButton(
                onClick = {
                    navController.navigate(Routes.ADD_EVENT)
=======

=======
>>>>>>> 8ed41c6 (fix: view)
            Column {

                FloatingActionButton(
                    onClick = {
                        navController.navigate(Routes.ADD_CATEGORY)
                    }
                ) {
                    Text("C")
                }

                Spacer(modifier = Modifier.height(12.dp))

                FloatingActionButton(
                    onClick = {
                        navController.navigate(Routes.ADD_EVENT)
                    }
                ) {
                    Text("+")
>>>>>>> 61f5555 (fix: dependencies)
                }
            ) {

                Text("+")
            }
        }
<<<<<<< HEAD
<<<<<<< HEAD
    ) { paddingValues ->

        if(events.isEmpty()) {

            EmptyState()

        } else {

            LazyColumn(
                contentPadding = paddingValues
            ) {

                items(events) {

                    EventCard(
                        event = it
                    ) {

=======

=======
>>>>>>> 8ed41c6 (fix: view)
    ) { paddingValues ->

        if (events.isEmpty()) {

            EmptyState()

        } else {

            LazyColumn(
                modifier = Modifier.padding(horizontal = 16.dp),
                contentPadding = paddingValues
            ) {

                groupedEvents.forEach { (categoryId, categoryEvents) ->

                    val categoryName =
                        categories.find { it.id == categoryId }?.name
                            ?: "Sin categoría"

                    item {
                        Text(
                            text = categoryName,
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(vertical = 12.dp)
                        )
>>>>>>> 61f5555 (fix: dependencies)
                    }

                    items(categoryEvents) { event ->

                        EventCard(
                            event = event
                        ) {

                            navController.navigate(
                                "${Routes.DETAIL}/${event.id}"
                            )
                        }
                    }
                }
            }
        }
    }
}