package com.example.test6.views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test6.R
import com.example.test6.models.Post

class MyAdapter(private val context: Context, private val posts: List<Post>):
    RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView){
        fun bind(post: Post) {
            tvId.text = "Post # ${post.id}"
            tvTitle.text = "Title: ${post.title}"
            tvBody.text = "Body: ${post.body}"
        }

        private val tvId = itemView.findViewById<TextView>(R.id.tvId)
        private val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        private val tvBody = itemView.findViewById<TextView>(R.id.tvBody)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.post_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount() = posts.size
}