package com.develop.eventmaster.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    val categories by viewModel.categories.collectAsState()

    val groupedEvents = events.groupBy { it.categoryId }

    Scaffold(
        floatingActionButton = {
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
                }
            }
        }
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