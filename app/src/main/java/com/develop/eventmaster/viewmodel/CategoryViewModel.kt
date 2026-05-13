package com.develop.eventmaster.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.eventmaster.data.local.entities.CategoryEntity
import com.develop.eventmaster.data.repository.CategoryRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CategoryViewModel(
    private val repository: CategoryRepository
) : ViewModel() {

    var categoryName by mutableStateOf("")

    var categoryError by mutableStateOf<String?>(null)

    val categories = repository.getAllCategories()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    fun validateCategory(): Boolean {

        return when {

            categoryName.isBlank() -> {

                categoryError = "Ingrese un nombre de categoría"

                false
            }

            else -> {

                categoryError = null

                true
            }
        }
    }

    fun addCategory() {

        if (!validateCategory()) return

        viewModelScope.launch {

            repository.insert(
                CategoryEntity(
                    name = categoryName
                )
            )

            categoryName = ""

            categoryError = null
        }
    }
}