package com.develop.eventmaster.data.local.dao

import androidx.room3.Dao
import androidx.room3.Delete
import androidx.room3.Insert
import androidx.room3.Query
import androidx.room3.Update
import com.develop.eventmaster.data.local.entities.EventEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {

    @Query("SELECT * FROM EventEntity ORDER BY id DESC")
    fun getAll(): Flow<List<EventEntity>>

    @Insert
    suspend fun insert(event: EventEntity)

    @Update
    suspend fun update(event: EventEntity)

    @Delete
    suspend fun delete(event: EventEntity)

    @Query("SELECT * FROM EventEntity WHERE id = :id")
    suspend fun getById(id: Int): EventEntity

    @Query("SELECT * FROM EventEntity WHERE categoryId = :categoryId")
    fun getEventsByCategory(categoryId: Int): Flow<List<EventEntity>>
}