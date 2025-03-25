package com.example.bt6api.data.api

import com.example.bt6api.data.models.Attachment
import com.example.bt6api.data.models.Reminder
import com.example.bt6api.data.models.Subtask
import com.example.bt6api.data.models.Task
import retrofit2.http.GET

interface ApiService {
    @GET("Posts")
    suspend fun getTasks(): List<Task>
}