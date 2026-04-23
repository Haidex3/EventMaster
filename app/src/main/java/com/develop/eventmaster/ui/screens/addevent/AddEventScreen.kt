package com.develop.eventmaster.ui.screens.addevent

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
<<<<<<< HEAD
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
=======
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.develop.eventmaster.ui.components.CategoryChip
>>>>>>> 61f5555 (fix: dependencies)
import com.develop.eventmaster.ui.components.CustomButton
import com.develop.eventmaster.ui.components.CustomTextField
import com.develop.eventmaster.viewmodel.EventViewModel

@Composable
fun AddEventScreen(
    navController: NavController,
    viewModel: EventViewModel
) {

<<<<<<< HEAD
    Scaffold {

        Column(
            modifier = Modifier.padding(it)
=======
    val categories by viewModel.categories.collectAsState()

    Scaffold {

        Column(
            modifier = Modifier
                .padding(it)
                .padding(16.dp)
>>>>>>> 61f5555 (fix: dependencies)
        ) {

            CustomTextField(
                value = viewModel.title,
                onValueChange = {
                    viewModel.title = it
<<<<<<< HEAD
=======
                    viewModel.titleError = null
>>>>>>> 61f5555 (fix: dependencies)
                },
                label = "Título"
            )

<<<<<<< HEAD
=======
            if (viewModel.titleError != null) {

                Text(
                    text = viewModel.titleError!!,
                    color = MaterialTheme.colorScheme.error
                )
            }

>>>>>>> 61f5555 (fix: dependencies)
            CustomTextField(
                value = viewModel.description,
                onValueChange = {
                    viewModel.description = it
<<<<<<< HEAD
=======
                    viewModel.descriptionError = null
>>>>>>> 61f5555 (fix: dependencies)
                },
                label = "Descripción"
            )

<<<<<<< HEAD
=======
            if (viewModel.descriptionError != null) {

                Text(
                    text = viewModel.descriptionError!!,
                    color = MaterialTheme.colorScheme.error
                )
            }

            Text(
                text = "Selecciona una categoría",
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )

            LazyRow {

                items(categories) { category ->

                    CategoryChip(
                        category = category,
                        selected = viewModel.selectedCategory == category.name,
                        onClick = {
                            viewModel.selectedCategory = category.name
                            viewModel.categoryError = null
                        }
                    )
                }
            }

            if (viewModel.categoryError != null) {

                Text(
                    text = viewModel.categoryError!!,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

>>>>>>> 61f5555 (fix: dependencies)
            CustomButton(
                text = "Guardar"
            ) {

<<<<<<< HEAD
                viewModel.addEvent()

                navController.popBackStack()
=======
                val isValid = viewModel.validateEvent()

                if (isValid) {

                    viewModel.addEvent()

                    navController.popBackStack()
                }
>>>>>>> 61f5555 (fix: dependencies)
            }
        }
    }
}