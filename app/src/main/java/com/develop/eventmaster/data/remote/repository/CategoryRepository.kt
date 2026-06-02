package com.develop.eventmaster.data.repository

import com.develop.eventmaster.data.local.dao.CategoryDao
import com.develop.eventmaster.data.local.entities.CategoryEntity
import kotlinx.coroutines.flow.Flow

class CategoryRepository(
    private val dao: CategoryDao
) {

    fun getAllCategories(): Flow<List<CategoryEntity>> {

        return dao.getAll()
    }

    suspend fun insert(category: CategoryEntity) {

        dao.insert(category)
    }

    suspend fun getCategoryById(id: Int): CategoryEntity {

        return dao.getById(id)
    }
}