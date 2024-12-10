package com.example.failure30.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.failure30.domain.model.BOOK


const val NON_EXISTENT_BOOK_ID = -1
@Composable
fun BookListContent(innerPadding : PaddingValues,
                    books: List<BOOK>,
                    onBookClick : (BOOK) -> Unit,
                    onUpdateClick : (BOOK) -> Unit,
                    onDeletUpdate : (BOOK) -> Unit,
                    onEmptyTittleUpdate : () -> Unit,
                    OnEmptyAuthorUpdate : () -> Unit,
                    onNoUpdate : () -> Unit
                    )
{

    var bookId by remember { mutableStateOf(NON_EXISTENT_BOOK_ID) }
    LazyColumn (modifier = Modifier.fillMaxSize().padding(innerPadding))
    {
        items(
            items = books,
            key = {
                book -> book.id
            })
        {
            book ->
            if(bookId!=book.id)
            {
                BookCard(book = book,
                    onBookClick = {
                        onBookClick(book)
                    },
                    onEditClick = { bookId = book.id},
                    onDeleteClick = {
                        onDeletUpdate(book)
                        bookId = NON_EXISTENT_BOOK_ID


                    }
                )


            }
            else
            {
                EditableCard(
                    book = book,
                    onUpdateCLick = { updatedBook ->
                        updatedBook.apply {
                            if(tittle.isEmpty())
                            {
                                onEmptyTittleUpdate()
                            }
                            else if (author.isEmpty())
                            {
                                OnEmptyAuthorUpdate()
                            }
                            else
                            {
                                if (updatedBook!=book)
                                {
                                    onUpdateClick(updatedBook)
                                }
                                else{
                                    onNoUpdate()
                                }
                                bookId=NON_EXISTENT_BOOK_ID
                            }
                        }
                    },
                    onCancel = {
                        bookId = NON_EXISTENT_BOOK_ID
                    }

                    )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun showontent()
{
    BookListContent(
        innerPadding = PaddingValues(8.dp),
        books = listOf(BOOK(1,"The Great Gatsby", "F. Scott Fitzgerald")
        ),
       onBookClick = {},
        onDeletUpdate = {},
        onUpdateClick = {},
        onEmptyTittleUpdate = {},
        OnEmptyAuthorUpdate = {},
        onNoUpdate = {}

    )
}