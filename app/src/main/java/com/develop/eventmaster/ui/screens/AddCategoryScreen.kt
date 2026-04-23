package com.develop.eventmaster.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.develop.eventmaster.viewmodel.EventViewModel


@Composable
fun AddCategoryScreen(navController: NavController, viewModel: EventViewModel) {

    var name by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Nueva Categoría", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = name,
            onValueChange = {
                name = it
                error = ""
            },
            label = { Text("Nombre categoría") }
        )

        if (error.isNotEmpty()) {
            Text(error, color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            if (name.isBlank()) {
                error = "Campo obligatorio"
            } else {
                viewModel.addCategory(name)
                navController.popBackStack()
            }
        }) {
            Text("Guardar")
        }
    }
}