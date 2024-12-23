package com.example.failure30.domain.Repository

import com.example.failure30.domain.model.BOOK
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    fun getBookList(): Flow<List<BOOK>>

    suspend fun getBookById(id: Int): BOOK?

    suspend fun insertBook(book: BOOK)

    suspend fun updateBook(book: BOOK)

    suspend fun deleteBook(book: BOOK)
}