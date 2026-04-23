package com.develop.eventmaster.data.repository

import com.develop.eventmaster.data.local.dao.EventDao
import com.develop.eventmaster.data.local.entities.EventEntity
import javax.inject.Inject

class EventRepository @Inject constructor(
    private val dao: EventDao
) {

    fun getAll() = dao.getAll()

    suspend fun insert(event: EventEntity) {
        dao.insert(event)
    }

    suspend fun getById(id: Int) = dao.getById(id)
}