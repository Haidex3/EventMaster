package com.develop.eventmaster.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.eventmaster.data.remote.repository.CategoryRepository
import com.develop.eventmaster.model.Category
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CategoryViewModel(
    private val repository: CategoryRepository
) : ViewModel() {

    var categoryName by mutableStateOf("")

    var categoryError by mutableStateOf<String?>(null)

    private val _categories =
        MutableStateFlow<List<Category>>(emptyList())

    val categories: StateFlow<List<Category>>
        get() = _categories

    init {
        loadCategories()
    }

    fun loadCategories() {

        viewModelScope.launch {

            _categories.value =
                repository.getAllCategories()
        }
    }

    fun validateCategory(): Boolean {

        return when {

            categoryName.isBlank() -> {

                categoryError =
                    "Ingrese un nombre de categoría"

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

            repository.insert(categoryName)

            categoryName = ""

            loadCategories()
        }
    }
}