package com.example.mvvmpractice.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmpractice.R
import com.example.mvvmpractice.databinding.ActivityMainBinding
import com.example.mvvmpractice.main.adapter.MainAdapter
import com.example.mvvmpractice.room.entity.Todo
import com.example.mvvmpractice.viewmodel.TodoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var vm: TodoViewModel
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding?.lifecycleOwner = this

        val adapter = MainAdapter()
        binding?.mainRcv?.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        }

        vm = ViewModelProviders.of(this).get(TodoViewModel::class.java)
        vm.getAll().observe(this, Observer { items ->
            adapter.getAll(items)
        })

        main_fab.setOnClickListener {
            vm.insert(Todo(0, System.currentTimeMillis().toString(), "20200217", "20200228", "c"))
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
