package com.develop.eventmaster.data.remote.repository

import com.develop.eventmaster.data.remote.api.EventMasterApi
import com.develop.eventmaster.data.remote.dto.CreateCategoryRequest
import com.develop.eventmaster.model.Category

class CategoryRepository(
    private val api: EventMasterApi
) {

    suspend fun getAllCategories(): List<Category> {

        return api.getCategories().map {

            Category(
                id = it.id,
                name = it.name
            )
        }
    }

    suspend fun insert(name: String) {

        api.createCategory(
            CreateCategoryRequest(
                name = name
            )
        )
    }
}