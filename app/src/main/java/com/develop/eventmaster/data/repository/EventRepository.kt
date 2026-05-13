package com.develop.eventmaster.data.repository

import com.develop.eventmaster.data.local.dao.EventDao
import com.develop.eventmaster.data.local.entities.EventEntity
import kotlinx.coroutines.flow.Flow

class EventRepository(
    private val dao: EventDao
) {

    fun getAllEvents(): Flow<List<EventEntity>> {

        return dao.getAll()
    }

    suspend fun insertEvent(event: EventEntity) {

        dao.insert(event)
    }

    suspend fun getEventById(id: Int): EventEntity {

        return dao.getById(id)
    }

    suspend fun deleteEvent(event: EventEntity) {

        dao.delete(event)
    }

    suspend fun updateEvent(event: EventEntity) {

        dao.update(event)
    }
}