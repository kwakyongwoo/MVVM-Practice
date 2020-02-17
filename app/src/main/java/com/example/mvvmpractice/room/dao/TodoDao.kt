package com.example.mvvmpractice.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvmpractice.room.entitiy.Todo

@Dao
interface TodoDao {
    @Insert
    fun insertTodo(vararg todo: Todo)

    @Delete
    fun deleteTodo(vararg todo: Todo)

    @Update
    fun updateTodo(vararg todo: Todo)

    @Query("SELECT * FROM todo ORDER BY dDate")
    fun getAllTodos() : LiveData<List<Todo>>

    @Query("SELECT * FROM todo WHERE id=:id")
    fun getTodo(id: Int) : Todo
}