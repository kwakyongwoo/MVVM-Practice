package com.example.mvvmpractice.main.viewholder

import android.graphics.Color
import android.graphics.Paint
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmpractice.databinding.ActivityMainBinding
import com.example.mvvmpractice.databinding.ItemTodoBinding
import com.example.mvvmpractice.room.entity.Todo
import kotlinx.android.synthetic.main.item_todo.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.absoluteValue

class MainViewHolder(private val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Todo) {
        binding.apply {
            this.item = item
        }
    }
}