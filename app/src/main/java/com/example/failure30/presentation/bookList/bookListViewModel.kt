package com.example.failure30.presentation.bookList

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.failure30.core.launchCatching
import com.example.failure30.domain.Repository.BookRepository
import com.example.failure30.domain.model.BOOK
import com.example.failure30.domain.model.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject





@HiltViewModel
class BookViewModel @Inject constructor(private val repo: BookRepository) : ViewModel() {
    var insertbook by mutableStateOf<Response<Unit>>(Response.Loading)
        private set
    var updateBookResponse by mutableStateOf<Response<Unit>>(Response.Loading)
        private set
    var deleteBookResponse by mutableStateOf<Response<Unit>>(Response.Loading)
        private set
    val bookListResponseFlow= flow {
        repo.getBookList().collect { booksList ->
            val bookListResponse = launchCatching {
                booksList
            }
            emit(bookListResponse)
        }
    }
    fun insertbook(book: BOOK)  = viewModelScope.launch {
        insertbook = launchCatching {
            repo.insertBook(book)
        }
    }

    fun updateBook(book: BOOK) = viewModelScope.launch {
        updateBookResponse = launchCatching {
            repo.updateBook(book)
        }
    }
        fun deleteBook(book: BOOK) = viewModelScope.launch {
            deleteBookResponse = launchCatching {
                repo.deleteBook(book)
            }
        }



    }



