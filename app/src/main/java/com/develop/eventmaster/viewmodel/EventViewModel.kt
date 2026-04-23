package com.develop.eventmaster.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.eventmaster.data.local.entities.EventEntity
import com.develop.eventmaster.data.repository.EventRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class EventViewModel(
    private val repository: EventRepository
) : ViewModel() {

    var title by mutableStateOf("")

    var description by mutableStateOf("")

    val events = repository.getAllEvents()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    fun addEvent() {

        if(title.isBlank()) return

        viewModelScope.launch {

            repository.insertEvent(
                EventEntity(
                    title = title,
                    description = description,
                    place = "Sin lugar",
                    date = "Sin fecha",
                    categoryId = 1
                )
            )

            title = ""

            description = ""
        }
    }
}