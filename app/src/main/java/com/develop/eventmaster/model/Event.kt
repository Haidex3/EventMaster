package com.develop.eventmaster.model

data class Event(

    val id: Int,

    val title: String,

    val description: String,

    val place: String,

    val date: String,

    val categoryId: Int
)