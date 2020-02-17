package com.example.mvvmpractice.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmpractice.R
import com.example.mvvmpractice.main.adapter.MainAdapter
import com.example.mvvmpractice.room.entitiy.Todo
import com.example.mvvmpractice.viewmodel.TodoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var vm: TodoViewModel
    private var adapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = MainAdapter({ todo ->

        }, { todo ->
            deleteTodo(todo)
        })
        main_rcv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        main_rcv.adapter = adapter

        vm = ViewModelProviders.of(this).get(TodoViewModel::class.java)

        vm.getAll().observe(this, Observer { items ->
            adapter?.getAll(items)
        })

        main_fab.setOnClickListener {
            vm.insert(Todo(0, System.currentTimeMillis().toString(), "a", "b", "c"))
        }
    }

    private fun deleteTodo(todo: Todo) {
        AlertDialog.Builder(this).apply { 
            setTitle("${todo.title} 삭제")
            setPositiveButton("예") { dialog, which ->
                vm.delete(todo)
            }
            setNegativeButton("아니요") { dialog, which ->  
                
            }
            show()
        }
    }
}
