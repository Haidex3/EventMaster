package com.develop.eventmaster.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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

    Scaffold(

        floatingActionButton = {

            FloatingActionButton(
                onClick = {
                    navController.navigate(Routes.ADD_EVENT)
                }
            ) {

                Text("+")
            }
        }
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

                    }
                }
            }
        }
    }
}