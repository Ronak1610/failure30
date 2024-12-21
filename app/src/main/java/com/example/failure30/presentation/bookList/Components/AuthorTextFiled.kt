package com.example.failure30.presentation.bookList.Components

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.example.failure30.R

@Composable
fun AuthorTextField(author : String , onAuthorChange : (String)-> Unit)
{

    var author by remember { mutableStateOf(author) }
    TextField(value = author, onValueChange = { newAutor ->
        author = newAutor
        onAuthorChange(newAutor)
    },
        placeholder = { Text(text = stringResource(id = R.string.book_author)) }
    )
}