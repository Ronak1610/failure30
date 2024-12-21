package com.example.failure30.presentation.bookList

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.failure30.R
import com.example.failure30.components.LaunchIndicator
import com.example.failure30.core.printError
import com.example.failure30.core.showToastMessage
import com.example.failure30.domain.model.BOOK
import com.example.failure30.domain.model.Response
import com.example.failure30.presentation.bookList.Components.BookListContent
import com.example.failure30.presentation.bookList.Components.BookTopBar
import com.example.failure30.presentation.bookList.Components.EmptyBook
import com.example.failure30.presentation.bookList.Components.InsertActionFloating
import com.example.failure30.presentation.bookList.Components.InsertAlertDialog

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(modifier: Modifier,viewModel: BookViewModel= hiltViewModel(),
               navigateToBookDetailsScreen: (BOOK) -> Unit
               ) {
val context = LocalContext.current
    val bookListResponse by viewModel.bookListResponseFlow.collectAsStateWithLifecycle(Response.Loading)
    var insertingBook by remember { (mutableStateOf(false)) }
    var updatingBook by remember { (mutableStateOf(false)) }
    var deletingBook by remember { (mutableStateOf(false)) }
    var insertDialogState by remember { (mutableStateOf(false)) }
    Scaffold (
        topBar = {
            BookTopBar()
        },
        floatingActionButton = {
            InsertActionFloating(
                onInsertClick = {
                insertDialogState = true

            }
            )
        }
    ){ innerpadding ->
        when(val bookListResponse = bookListResponse)
        {
            is Response.Loading -> LaunchIndicator()
            is Response.Success -> bookListResponse.data.let {
                booksList ->
                if(booksList.isEmpty()) {
                    EmptyBook()
                } else {
                    BookListContent(
                        innerPadding = innerpadding,
                        books = booksList,
                        onBookClick = navigateToBookDetailsScreen,
                        onUpdateClick = { book ->
                            viewModel.updateBook(book)
                            updatingBook = true
                        },
                        onDeletUpdate = { book ->
                            viewModel.deleteBook(book)
                            deletingBook = true
                        },

                        onEmptyTittleUpdate = {
                            showToastMessage(context, R.string.empty_title_message)
                        },
                        onNoUpdate = {
                            showToastMessage(context, R.string.no_updates_message)
                        },
                        OnEmptyAuthorUpdate = {
                            showToastMessage(context,R.string.empty_author_message)
                        }
                    )
                }
            }

            is Response.Failure -> printError(bookListResponse.e)
        }
    }
    if (insertDialogState)
    {
        InsertAlertDialog(
            onEmptyTittle = {
                showToastMessage(context,R.string.empty_title_message)
            },
            onEmptyAuthor = {
                showToastMessage(context,R.string.empty_author_message)
            },
            onInsertBox = { book ->
                viewModel.insertbook(book)
                insertingBook =true
            },
            onCancel = {
                insertDialogState = false
            }
        )
    }
    if (insertingBook)
    {
        when(val bookResponse = viewModel.insertbook)
        {
            is Response.Loading -> LaunchIndicator()
            is Response.Success -> insertingBook = false
            is Response.Failure -> printError(bookResponse.e)
        }
        if (updatingBook)
            when(val bookResponse = viewModel.updateBookResponse)
            { is Response.Loading -> LaunchIndicator()
                is Response.Success -> updatingBook = false
                is Response.Failure -> printError(bookResponse.e)
            }

        if(deletingBook)
        when(val bookResponse = viewModel.deleteBookResponse)
        {
            is Response.Loading -> LaunchIndicator()
            is Response.Success -> deletingBook = false
            is Response.Failure -> printError(bookResponse.e)
        }
    }
}
@Preview
@Composable
fun ListScreenPreview()
{

}