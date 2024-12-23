package com.example.failure30.presentation.bookList.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import com.example.failure30.R
import com.example.failure30.components.ActionButton
import com.example.failure30.domain.model.BOOK

@Composable
fun EditableCard(book : BOOK,
                 onUpdateCLick : (BOOK)-> Unit,
                 onCancel : () -> Unit)
{
var updatedBook by remember { mutableStateOf(book)
}
    Card(modifier = Modifier.fillMaxWidth().padding(
        start = 8.dp,
        top = 4.dp,
        end = 8.dp,
        bottom = 4.dp
    ),
        shape = MaterialTheme.shapes.small,
        elevation = 3.dp
    )

        {
            Column(modifier = Modifier.padding(8.dp)) {
                TittleTestField(tittle = updatedBook.tittle,
                    onUpdate = { newTittle ->
                        updatedBook = updatedBook.copy(
                            tittle = newTittle
                        )
                    })
                Spacer(modifier = Modifier.height(8.dp))
                AuthorTextField(author = updatedBook.author,
                    onAuthorChange = { authorChange ->
                        updatedBook = updatedBook.copy(
                            author = authorChange
                        )
                    })
                Row()
                {
                    ActionButton(
                        onActionClick = onCancel, textResID =
                        R.string.cancel_button
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    ActionButton(
                        onActionClick = { onUpdateCLick(updatedBook) },
                        textResID = R.string.update_button
                    )
                }
            }
        }

}
