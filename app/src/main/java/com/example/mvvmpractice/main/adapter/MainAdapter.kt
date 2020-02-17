package com.example.mvvmpractice.main.adapter

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmpractice.R
import com.example.mvvmpractice.main.viewholder.MainViewHolder
import com.example.mvvmpractice.room.entitiy.Todo

class MainAdapter(val itemClick: (Todo) -> Unit, val itemOnLongClick: (Todo) -> Unit) : RecyclerView.Adapter<MainViewHolder>() {
    private var todos: List<Todo> = ArrayList()

    fun getAll(todos: List<Todo>) {
        this.todos = todos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val viewHolder = MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false))

        viewHolder.itemView.setOnClickListener {
            itemClick(todos[viewHolder.adapterPosition])
        }

        viewHolder.itemView.setOnLongClickListener {
            itemOnLongClick(todos[viewHolder.adapterPosition])

            true
        }

        return viewHolder
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.onBind(todos[position])
    }
}