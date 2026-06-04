package com.develop.eventmaster.ui.screens.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.develop.eventmaster.viewmodel.EventViewModel

@Composable
fun DetailScreen(
    eventId: Int,
    viewModel: EventViewModel
) {

    val event = viewModel.getEventById(eventId)

    Scaffold { paddingValues ->

        event?.let {

            Card(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = it.title,
                        style = MaterialTheme.typography.headlineSmall
                    )

                    Text(
                        text = it.description,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                }
            }
        }
    }
}