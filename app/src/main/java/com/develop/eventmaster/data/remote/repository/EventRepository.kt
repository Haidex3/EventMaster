package com.develop.eventmaster.data.remote.repository

import com.develop.eventmaster.data.remote.api.EventMasterApi
import com.develop.eventmaster.data.remote.dto.CreateEventRequest
import com.develop.eventmaster.model.Event

class EventRepository(
    private val api: EventMasterApi
) {

    suspend fun getAllEvents(): List<Event> {

        return api.getEvents().map {

            Event(
                id = it.id,
                title = it.title,
                description = it.description,
                date = it.date,
                categoryId = it.category_id
            )
        }
    }

    suspend fun insertEvent(
        title: String,
        description: String,
        categoryId: Int
    ) {

        api.createEvent(
            CreateEventRequest(
                title = title,
                description = description,
                category_id = categoryId,
                date = "2026-06-03"
            )
        )
    }
}