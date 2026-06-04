package com.develop.eventmaster.model

import java.util.Date

data class Event(

    val id: Int,

    val title: String,

    val description: String,

    val categoryId: Int,

    val date: Date
)