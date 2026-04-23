package com.develop.eventmaster.data.local.entities


import androidx.room3.Entity
import androidx.room3.PrimaryKey
@Entity
data class EventEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val title: String,

    val description: String,

    val place: String,

    val date: String,

    val categoryId: Int
)