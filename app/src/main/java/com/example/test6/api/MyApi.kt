package com.example.test6.api

import com.example.test6.models.Post
import retrofit2.http.GET

interface MyApi {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}