package com.develop.eventmaster.data.local.dao


import androidx.room3.Query
import androidx.room3.Dao
import androidx.room3.Insert
import com.develop.eventmaster.data.local.entities.EventEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {

    @Query("SELECT * FROM EventEntity")
    fun getAll(): Flow<List<EventEntity>>

    @Insert
    suspend fun insert(event: EventEntity)

    @Query("SELECT * FROM EventEntity WHERE id = :id")
    suspend fun getById(id: Int): EventEntity
}