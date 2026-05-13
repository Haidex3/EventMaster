package com.develop.eventmaster.data.local

import androidx.room3.Database
import androidx.room3.RoomDatabase
import com.develop.eventmaster.data.local.dao.CategoryDao
import com.develop.eventmaster.data.local.dao.EventDao
import com.develop.eventmaster.data.local.entities.CategoryEntity
import com.develop.eventmaster.data.local.entities.EventEntity

@Database(
    entities = [
        CategoryEntity::class,
        EventEntity::class
    ],
    version = 3
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao

    abstract fun eventDao(): EventDao
}