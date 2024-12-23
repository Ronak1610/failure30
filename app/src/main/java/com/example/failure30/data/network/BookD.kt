package com.example.failure30.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.failure30.data.dao.BookDao
import com.example.failure30.domain.model.BOOK

@Database(
    entities = [BOOK::class],
    version = 1,
    exportSchema = false
)
abstract class BookDb:RoomDatabase() {
    abstract val bookDao: BookDao
}