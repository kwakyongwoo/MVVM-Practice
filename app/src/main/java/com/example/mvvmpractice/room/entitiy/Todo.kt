package com.example.mvvmpractice.room.entitiy

import androidx.room.Entity
import androidx.room.PrimaryKey

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