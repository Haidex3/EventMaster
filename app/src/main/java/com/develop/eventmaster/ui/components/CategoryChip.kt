package com.develop.eventmaster.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CategoryChip(name: String) {

    Text(
        text = name,
        modifier = Modifier
            .background(Color.LightGray)
            .padding(horizontal = 12.dp, vertical = 6.dp)
    )
}