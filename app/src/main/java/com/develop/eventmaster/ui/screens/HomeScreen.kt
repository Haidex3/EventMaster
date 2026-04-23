package com.develop.eventmaster.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.develop.eventmaster.viewmodel.EventViewModel


@Composable
fun HomeScreen(navController: NavController, viewModel: EventViewModel) {

    Scaffold(
        floatingActionButton = {
            Column {
                FloatingActionButton(onClick = {
                    navController.navigate("addCategory")
                }) {
                    Text("+C")
                }

                Spacer(modifier = Modifier.height(8.dp))

                FloatingActionButton(onClick = {
                    navController.navigate("addEvent")
                }) {
                    Text("+E")
                }
            }
        }
    ) { padding ->

        LazyColumn(modifier = Modifier.padding(padding)) {

            viewModel.categories.forEach { category ->

                item {
                    Text(
                        text = category.name,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(12.dp)
                    )
                }

                val events = viewModel.getEventsByCategory(category.id)

                events.forEach { event ->
                    item {
                        Text(
                            text = "- ${event.title}",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier
                                .padding(start = 20.dp, bottom = 6.dp)
                                .clickable {
                                    navController.navigate("detail/${event.id}")
                                }
                        )
                    }
                }
            }
        }
    }
}