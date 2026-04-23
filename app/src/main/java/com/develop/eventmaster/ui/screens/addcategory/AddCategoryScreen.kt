package com.develop.eventmaster.ui.screens.addcategory

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
            modifier = Modifier.padding(it)
        ) {

            CustomTextField(
                value = viewModel.categoryName,
                onValueChange = {
                    viewModel.categoryName = it
                },
                label = "Nombre categoría"
            )

            CustomButton(
                text = "Guardar"
            ) {

                viewModel.addCategory()

                navController.popBackStack()
            }
        }
    }
}