package com.develop.eventmaster.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.develop.eventmaster.model.Category
import com.develop.eventmaster.model.Event


class EventViewModel : ViewModel() {

    private var categoryId = 0
    private var eventId = 0

    val categories = mutableStateListOf<Category>()
    val events = mutableStateListOf<Event>()

    init {
        addCategory("Música")
        addCategory("Tecnología")
        addCategory("Deportes")
    }

    fun addCategory(name: String) {
        categories.add(Category(categoryId++, name))
    }

    fun addEvent(title: String, description: String, categoryId: Int) {
        events.add(Event(eventId++, title, description, categoryId))
    }

    fun getEventsByCategory(id: Int) =
        events.filter { it.categoryId == id }

    fun getEventById(id: Int) =
        events.find { it.id == id }
}