package com.example.failure30.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.failure30.core.BOOK_TABLE
import com.example.failure30.domain.model.BOOK
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {
    @Query("SELECT * FROM $BOOK_TABLE ORDER BY id ASC")
    fun getBookSList (): Flow<List<BOOK>>

    @Query("SELECT *FROM $BOOK_TABLE WHERE id = :id")
   suspend fun getBookId(id: Int): BOOK
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBook(book: BOOK)
    @Update
    suspend fun updateBook(book: BOOK)
    @Delete
    suspend fun deleteBook(
        book: BOOK
    )
}