package com.develop.eventmaster.data.local.entities

import androidx.room3.Entity
import androidx.room3.PrimaryKey


@Entity
data class CategoryEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val name: String
)