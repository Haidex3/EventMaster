package com.develop.eventmaster.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.develop.eventmaster.viewmodel.EventViewModel


@Composable
fun DetailScreen(
    navController: NavController,
    viewModel: EventViewModel,
    eventId: Int
) {

    val event = viewModel.getEventById(eventId)

    Column(modifier = Modifier.padding(16.dp)) {

        if (event != null) {

            Text(event.title, style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.height(10.dp))

            Text(event.description)

        } else {
            Text("Evento no encontrado")
        }
    }
}