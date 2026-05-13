package com.develop.eventmaster.ui.screens.addcategory

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.develop.eventmaster.ui.components.CustomButton
import com.develop.eventmaster.ui.components.CustomTextField
import com.develop.eventmaster.viewmodel.CategoryViewModel

@Composable
fun AddCategoryScreen(
    navController: NavController,
    viewModel: CategoryViewModel
) {

    Scaffold {

        Column(
            modifier = Modifier
                .padding(it)
                .padding(16.dp)
        ) {

            CustomTextField(
                value = viewModel.categoryName,
                onValueChange = {
                    viewModel.categoryName = it
                    viewModel.categoryError = null
                },
                label = "Nombre categoría"
            )

            if (viewModel.categoryError != null) {

                Text(
                    text = viewModel.categoryError!!,
                    color = MaterialTheme.colorScheme.error
                )
            }

            CustomButton(
                text = "Guardar"
            ) {

                val isValid = viewModel.validateCategory()

                if (isValid) {

                    viewModel.addCategory()

                    navController.popBackStack()
                }
            }
        }
    }
}