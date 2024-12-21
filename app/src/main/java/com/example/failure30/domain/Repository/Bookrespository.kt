package com.example.failure30.domain.Repository

import com.example.failure30.domain.model.BOOK
import kotlinx.coroutines.flow.Flow

interface Bookrespository {
    fun getBookList() : Flow<List<BOOK>>

    suspend fun getBookId(id : Int) : BOOK ?

    suspend fun insertBook(book: BOOK)

    suspend fun updatebook(book: BOOK)

    suspend fun deleteBook(book: BOOK)


}