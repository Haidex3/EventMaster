package com.develop.eventmaster.data.remote.api

import com.develop.eventmaster.data.remote.dto.CategoryDto
import com.develop.eventmaster.data.remote.dto.CreateCategoryRequest
import com.develop.eventmaster.data.remote.dto.CreateEventRequest
import com.develop.eventmaster.data.remote.dto.EventDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface EventMasterApi {

    @GET("categories")
    suspend fun getCategories(): List<CategoryDto>

    @POST("categories")
    suspend fun createCategory(
        @Body category: CreateCategoryRequest
    ): CategoryDto

    @GET("events")
    suspend fun getEvents(): List<EventDto>

    @POST("events")
    suspend fun createEvent(
        @Body event: CreateEventRequest
    ): EventDto
}