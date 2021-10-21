package com.example.test6.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test6.api.RetrofitInstance
import com.example.test6.models.Post
import kotlinx.coroutines.launch

private const val TAG = "MyViewModel"
class MyViewModel: ViewModel() {
    private val _posts: MutableLiveData<List<Post>> = MutableLiveData()
    val posts: LiveData<List<Post>>
        get() = _posts

    fun getPosts() {
        viewModelScope.launch {
            val fetchedPosts = RetrofitInstance.api.getPosts()

            _posts.value = fetchedPosts
        }
    }
}