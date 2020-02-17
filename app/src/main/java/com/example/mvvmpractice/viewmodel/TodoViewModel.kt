package com.example.mvvmpractice.viewmodel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.mvvmpractice.room.entity.Todo
import com.example.mvvmpractice.repository.TodoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TodoRepository = TodoRepository(application)
    private val allTodos: LiveData<List<Todo>> = repository.getAllTodo()

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun getAll() : LiveData<List<Todo>> {
        return allTodos
    }

    fun insert(todo: Todo) = viewModelScope.launch {
        repository.insertTodo(todo)
    }

    fun delete(todo: Todo) = viewModelScope.launch {
        repository.deleteTodo(todo)
    }

    fun update(todo: Todo) = viewModelScope.launch {
        repository.updateTodo(todo)
    }
}