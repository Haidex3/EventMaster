package com.develop.eventmaster.data.repository

import com.develop.eventmaster.data.local.dao.CategoryDao
import com.develop.eventmaster.data.local.entities.CategoryEntity
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val dao: CategoryDao
) {

    fun getAll() = dao.getAll()

    suspend fun insert(category: CategoryEntity) {
        dao.insert(category)
    }
}