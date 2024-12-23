package com.example.failure30.data.repository

import com.example.failure30.data.dao.BookDao
import com.example.failure30.domain.Repository.BookRepository
import com.example.failure30.domain.model.BOOK
import kotlinx.coroutines.flow.Flow

class BookRepositoryImpl(
    private val bookDao: BookDao
) : BookRepository{
    override fun getBookList() = bookDao.getBookSList()

    override suspend fun getBookById(id: Int) = bookDao.getBookId(id)

    override suspend fun insertBook(book: BOOK) = bookDao.insertBook(book)

    override suspend fun updateBook(book: BOOK) = bookDao.updateBook(book)

    override suspend fun deleteBook(book: BOOK) = bookDao.deleteBook(book)
}