package com.develop.eventmaster.ui.screens.addevent

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import com.develop.eventmaster.ui.components.CustomButton
import com.develop.eventmaster.ui.components.CustomTextField
import com.develop.eventmaster.viewmodel.EventViewModel

@Composable
fun AddEventScreen(
    navController: NavController,
    viewModel: EventViewModel
) {

    val categories by viewModel.categories.collectAsState()

    Scaffold { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            CustomTextField(
                value = viewModel.title,
                onValueChange = {
                    viewModel.title = it
                    viewModel.titleError = null
                },
                label = "Título"
            )

            viewModel.titleError?.let {
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error
                )
            }

            CustomTextField(
                value = viewModel.description,
                onValueChange = {
                    viewModel.description = it
                    viewModel.descriptionError = null
                },
                label = "Descripción"
            )

            viewModel.descriptionError?.let {
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error
                )
            }

            Text(
                text = "Selecciona una categoría",
                modifier = Modifier.padding(
                    top = 16.dp,
                    bottom = 8.dp
                )
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

            viewModel.categoryError?.let {
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            CustomButton(
                text = "Guardar"
            ) {

                if (viewModel.validateEvent()) {

                    viewModel.addEvent()

                    navController.popBackStack()
                }
            }
        }
    }
}