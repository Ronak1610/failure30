package com.example.failure30.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.failure30.core.BOOK_TABLE
import com.example.failure30.domain.model.BOOK
import kotlinx.coroutines.flow.Flow

@Dao
 interface bookDao {
     @Query ("SELECT * FROM $BOOK_TABLE ORDER BY id ASC")
     fun getBookSList (): Flow<List<BOOK>>

     @Query("SELECT *FROM $BOOK_TABLE WHERE id = :id")
     fun getBookId(id: Int): Flow<BOOK>
 }