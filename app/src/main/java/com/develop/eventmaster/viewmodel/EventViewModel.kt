package com.develop.eventmaster.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.eventmaster.data.local.entities.CategoryEntity
import com.develop.eventmaster.data.local.entities.EventEntity
import com.develop.eventmaster.data.repository.CategoryRepository
import com.develop.eventmaster.data.repository.EventRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
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

    val events = repository.getAllEvents()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    val categories = categoryRepository.getAllCategories()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

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

            val selectedCategoryEntity = categories.value.find {
                it.name == selectedCategory
            }

            repository.insertEvent(
                EventEntity(
                    title = title,
                    description = description,
                    categoryId = selectedCategoryEntity?.id ?: 1
                )
            )

            clearForm()
        }
    }

    fun getEventById(id: Int): EventEntity? {

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