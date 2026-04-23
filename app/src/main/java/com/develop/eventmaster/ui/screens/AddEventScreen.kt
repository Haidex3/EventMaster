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
    var selectedCategory by remember { mutableStateOf<Int?>(null) }
    var error by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Nuevo Evento", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(10.dp))

        TextField(value = title, onValueChange = { title = it }, label = { Text("Título") })

        TextField(value = description, onValueChange = { description = it }, label = { Text("Descripción") })

        Spacer(modifier = Modifier.height(10.dp))

        Text("Categorías:")

        viewModel.categories.forEach {
            Button(
                onClick = { selectedCategory = it.id },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(it.name)
            }
        }

        if (error.isNotEmpty()) {
            Text(error, color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            if (title.isBlank() || description.isBlank() || selectedCategory == null) {
                error = "Completa todos los campos"
            } else {
                viewModel.addEvent(title, description, selectedCategory!!)
                navController.popBackStack()
            }
        }) {
            Text("Guardar evento")
        }
    }
}