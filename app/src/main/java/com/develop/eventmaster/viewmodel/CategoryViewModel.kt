package com.develop.eventmaster.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.eventmaster.data.local.entities.CategoryEntity
import com.develop.eventmaster.data.repository.CategoryRepository
<<<<<<< HEAD
=======
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
>>>>>>> 61f5555 (fix: dependencies)
import kotlinx.coroutines.launch

class CategoryViewModel(
    private val repository: CategoryRepository
) : ViewModel() {

    var categoryName by mutableStateOf("")

<<<<<<< HEAD
    fun addCategory() {

        if(categoryName.isBlank()) return
=======
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
>>>>>>> 61f5555 (fix: dependencies)

        viewModelScope.launch {

            repository.insert(
                CategoryEntity(
                    name = categoryName
                )
            )

            categoryName = ""
<<<<<<< HEAD
=======

            categoryError = null
>>>>>>> 61f5555 (fix: dependencies)
        }
    }
}