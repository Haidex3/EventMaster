package com.develop.eventmaster.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.develop.eventmaster.model.Category
import com.develop.eventmaster.model.Event


class EventViewModel : ViewModel() {

    var categories = mutableStateListOf<Category>()
        private set

    var events = mutableStateListOf<Event>()
        private set

    private var categoryIdCounter = 0
    private var eventIdCounter = 0

    init {
        addCategory("Música")
        addCategory("Tecnología")
        addCategory("Deportes")
    }

    fun addCategory(name: String) {
        categories.add(Category(categoryIdCounter++, name))
    }

    fun addEvent(title: String, description: String, categoryId: Int) {
        events.add(Event(eventIdCounter++, title, description, categoryId))
    }

    fun getEventsByCategory(categoryId: Int): List<Event> {
        return events.filter { it.categoryId == categoryId }
    }

    fun getEventById(id: Int): Event? {
        return events.find { it.id == id }
    }
}