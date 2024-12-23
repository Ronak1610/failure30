package com.example.failure30.presentation.bookList.Components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

import com.example.failure30.R

@Composable
fun InsertActionFloating(onInsertClick : ()-> Unit)
{

    FloatingActionButton(onClick = onInsertClick)
    {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = stringResource(id = R.string.open_insert_book_dialog),

        )
    }
}
