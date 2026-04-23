package com.develop.eventmaster.ui.screens.addcategory

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
<<<<<<< HEAD
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
=======
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
>>>>>>> 61f5555 (fix: dependencies)
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
<<<<<<< HEAD
            modifier = Modifier.padding(it)
=======
            modifier = Modifier
                .padding(it)
                .padding(16.dp)
>>>>>>> 61f5555 (fix: dependencies)
        ) {

            CustomTextField(
                value = viewModel.categoryName,
                onValueChange = {
                    viewModel.categoryName = it
<<<<<<< HEAD
=======
                    viewModel.categoryError = null
>>>>>>> 61f5555 (fix: dependencies)
                },
                label = "Nombre categoría"
            )

<<<<<<< HEAD
=======
            if (viewModel.categoryError != null) {

                Text(
                    text = viewModel.categoryError!!,
                    color = MaterialTheme.colorScheme.error
                )
            }

>>>>>>> 61f5555 (fix: dependencies)
            CustomButton(
                text = "Guardar"
            ) {

<<<<<<< HEAD
                viewModel.addCategory()

                navController.popBackStack()
=======
                val isValid = viewModel.validateCategory()

                if (isValid) {

                    viewModel.addCategory()

                    navController.popBackStack()
                }
>>>>>>> 61f5555 (fix: dependencies)
            }
        }
    }
}