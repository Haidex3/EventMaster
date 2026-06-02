package com.develop.eventmaster.data.remote.dto

data class CreateEventRequest(
    val title: String,
    val description: String,
    val category_id: Int
)