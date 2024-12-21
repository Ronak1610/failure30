package com.example.failure30.presentation.bookList.Components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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
@Preview
@Composable
fun InsertActionFloatingPreview()
{
    InsertActionFloating(onInsertClick = {})
}