package com.example.mvvmpractice.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.mvvmpractice.room.dao.TodoDao
import com.example.mvvmpractice.room.database.MyDatabase
import com.example.mvvmpractice.room.entitiy.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodoRepository(application: Application) {

    private val todoDatabase = MyDatabase.getInstance(application)!!
    private val todoDao: TodoDao = todoDatabase.todoDao()
    private val todos: LiveData<List<Todo>> = todoDao.getAllTodos()

    fun getAllTodo(): LiveData<List<Todo>> {
        return todos
    }

    suspend fun insertTodo(todo: Todo) {
        withContext(Dispatchers.IO) {
            todoDao.insertTodo(todo)
        }
    }

    suspend fun deleteTodo(todo: Todo) {
        withContext(Dispatchers.IO) {
            todoDao.deleteTodo(todo)
        }
    }

    suspend fun updateTodo(todo: Todo) {
        withContext(Dispatchers.IO) {
            todoDao.updateTodo(todo)
        }
    }
}