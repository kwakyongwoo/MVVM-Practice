package com.example.mvvmpractice.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmpractice.room.dao.TodoDao
import com.example.mvvmpractice.room.entitiy.Todo

@Database(entities = [Todo::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao

    companion object {
        private var INSTANCE: MyDatabase? = null

        fun getInstance(context: Context) : MyDatabase? {
            if (INSTANCE == null) {
                synchronized(MyDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, MyDatabase::class.java, "MyDatabase.db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}