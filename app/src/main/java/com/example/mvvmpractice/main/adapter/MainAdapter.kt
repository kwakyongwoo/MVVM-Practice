package com.example.mvvmpractice.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmpractice.R
import com.example.mvvmpractice.main.viewholder.MainViewHolder
import com.example.mvvmpractice.room.entity.Todo

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {
    private var todos: List<Todo> = listOf()

    fun getAll(todos: List<Todo>) {
        this.todos = todos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val viewHolder = MainViewHolder(DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_todo, parent, false))

        return viewHolder
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.apply {
            bind(todos[position])
        }
    }
}