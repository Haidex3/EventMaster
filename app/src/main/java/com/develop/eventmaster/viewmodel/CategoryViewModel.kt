package com.develop.eventmaster.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.develop.eventmaster.data.local.entities.CategoryEntity
import com.develop.eventmaster.data.repository.CategoryRepository
import kotlinx.coroutines.launch

class CategoryViewModel(
    private val repository: CategoryRepository
) : ViewModel() {

    var categoryName by mutableStateOf("")

    fun addCategory() {

        if(categoryName.isBlank()) return

        viewModelScope.launch {

            repository.insert(
                CategoryEntity(
                    name = categoryName
                )
            )

            categoryName = ""
        }
    }
}