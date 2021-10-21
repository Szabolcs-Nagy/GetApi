package com.example.test6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test6.models.Post
import com.example.test6.viewmodel.MyViewModel
import com.example.test6.views.MyAdapter
import com.example.test6.databinding.ActivityMainBinding


private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MyViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var postAdapter: MyAdapter
    private val myPosts = mutableListOf<Post>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        viewModel.posts.observe(this, Observer { posts ->
            myPosts.addAll(posts)
            postAdapter.notifyDataSetChanged()
        })

        postAdapter = MyAdapter(this, myPosts)
        binding.rvPosts.adapter = postAdapter
        binding.rvPosts.layoutManager = LinearLayoutManager(this)

        binding.btn.setOnClickListener {

            viewModel.getPosts()
        }

    }
}