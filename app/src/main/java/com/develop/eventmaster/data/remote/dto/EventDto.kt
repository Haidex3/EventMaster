package com.develop.eventmaster.data.remote.dto

import java.util.Date

data class EventDto(
    val id: Int,
    val title: String,
    val description: String,
    val date: Date,
    val category_id: Int
)