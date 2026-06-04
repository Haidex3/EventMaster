package com.develop.eventmaster.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.develop.eventmaster.model.Category

@Composable
fun CategoryChip(
    category: Category,
    selected: Boolean,
    onClick: () -> Unit
) {

    val backgroundColor =
        if (selected) {
            MaterialTheme.colorScheme.primary
        } else {
            Color.LightGray
        }

    val textColor =
        if (selected) {
            MaterialTheme.colorScheme.onPrimary
        } else {
            Color.Black
        }

    Text(
        text = category.name,
        color = textColor,
        modifier = Modifier
            .padding(end = 8.dp)
            .clip(RoundedCornerShape(50.dp))
            .background(backgroundColor)
            .clickable {
                onClick()
            }
            .padding(
                horizontal = 16.dp,
                vertical = 10.dp
            )
    )
}