package com.example.mvvmpractice.room.entity

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*

@Entity(tableName = "todo")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var title: String,
    var sDate: String,
    var dDate: String,
    var memo: String
) {
    var checked = false
}