package com.develop.eventmaster.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.develop.eventmaster.viewmodel.EventViewModel

@Composable
fun AddEventScreen(navController: NavController, viewModel: EventViewModel) {

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var selectedCategoryId by remember { mutableStateOf<Int?>(null) }
    var error by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Nuevo Evento")

        TextField(
            value = title,
            onValueChange = {
                title = it
                error = ""
            },
            label = { Text("Título") }
        )

        TextField(
            value = description,
            onValueChange = {
                description = it
                error = ""
            },
            label = { Text("Descripción") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text("Selecciona Categoría")

        viewModel.categories.forEach {
            Button(
                onClick = { selectedCategoryId = it.id },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(it.name)
            }
        }

        if (error.isNotEmpty()) {
            Text(error, color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            if (title.isBlank() || description.isBlank() || selectedCategoryId == null) {
                error = "Completa todos los campos"
            } else {
                viewModel.addEvent(title, description, selectedCategoryId!!)
                navController.popBackStack()
            }
        }) {
            Text("Guardar Evento")
        }
    }
}