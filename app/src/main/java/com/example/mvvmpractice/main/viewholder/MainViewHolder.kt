package com.example.mvvmpractice.main.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmpractice.room.entitiy.Todo
import kotlinx.android.synthetic.main.item_todo.view.*

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun onBind(item: Todo) {
        itemView.item_tv_1.text = item.title
        itemView.item_tv_2.text = item.sDate
    }
}