package com.develop.eventmaster.ui.screens.addevent

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.develop.eventmaster.ui.components.CustomButton
import com.develop.eventmaster.ui.components.CustomTextField
import com.develop.eventmaster.viewmodel.EventViewModel

@Composable
fun AddEventScreen(
    navController: NavController,
    viewModel: EventViewModel
) {

    Scaffold {

        Column(
            modifier = Modifier.padding(it)
        ) {

            CustomTextField(
                value = viewModel.title,
                onValueChange = {
                    viewModel.title = it
                },
                label = "Título"
            )

            CustomTextField(
                value = viewModel.description,
                onValueChange = {
                    viewModel.description = it
                },
                label = "Descripción"
            )

            CustomButton(
                text = "Guardar"
            ) {

                viewModel.addEvent()

                navController.popBackStack()
            }
        }
    }
}