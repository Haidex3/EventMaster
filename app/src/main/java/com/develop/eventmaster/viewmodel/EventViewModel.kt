package com.develop.eventmaster.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.eventmaster.data.remote.repository.CategoryRepository
import com.develop.eventmaster.data.remote.repository.EventRepository
import com.develop.eventmaster.model.Category
import com.develop.eventmaster.model.Event
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EventViewModel(
    private val repository: EventRepository,
    private val categoryRepository: CategoryRepository
) : ViewModel() {

    var title by mutableStateOf("")

    var description by mutableStateOf("")

    var selectedCategory by mutableStateOf("")

    var titleError by mutableStateOf<String?>(null)

    var descriptionError by mutableStateOf<String?>(null)

    var categoryError by mutableStateOf<String?>(null)

    var date by mutableStateOf("")
    var dateError by mutableStateOf<String?>(null)

    private val _events =
        MutableStateFlow<List<Event>>(emptyList())

    val events: StateFlow<List<Event>>
        get() = _events

    private val _categories =
        MutableStateFlow<List<Category>>(emptyList())

    val categories: StateFlow<List<Category>>
        get() = _categories

    init {

        loadCategories()

        loadEvents()
    }

    fun loadEvents() {

        viewModelScope.launch {

            _events.value =
                repository.getAllEvents()
        }
    }

    fun loadCategories() {

        viewModelScope.launch {

            _categories.value =
                categoryRepository.getAllCategories()
        }
    }

    fun validateEvent(): Boolean {

        var isValid = true

        if (title.isBlank()) {

            titleError = "Ingrese un título"

            isValid = false

        } else {

            titleError = null
        }

        if (description.isBlank()) {

            descriptionError = "Ingrese una descripción"

            isValid = false

        } else {

            descriptionError = null
        }

        if (date.isBlank()) {
            dateError = "Debe seleccionar una fecha"
            isValid = false
        }
        else {

            dateError = null
        }

        if (selectedCategory.isBlank()) {

            categoryError = "Seleccione una categoría"

            isValid = false

        } else {

            categoryError = null
        }

        return isValid
    }

    fun addEvent() {

        if (!validateEvent()) return

        viewModelScope.launch {

            val selectedCategoryModel =
                categories.value.find {
                    it.name == selectedCategory
                }

            repository.insertEvent(
                title = title,
                description = description,
                categoryId = selectedCategoryModel?.id ?: 1
            )

            loadEvents()

            clearForm()
        }
    }

    fun getEventById(id: Int): Event? {

        return events.value.find {
            it.id == id
        }
    }

    fun getCategoryName(categoryId: Int): String {

        return categories.value.find {
            it.id == categoryId
        }?.name ?: "Sin categoría"
    }

    private fun clearForm() {

        title = ""

        description = ""

        selectedCategory = ""

        titleError = null

        descriptionError = null

        categoryError = null
    }
}