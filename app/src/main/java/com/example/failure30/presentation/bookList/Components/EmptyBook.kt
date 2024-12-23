package com.example.failure30.presentation.bookList.Components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.failure30.R

@Composable
fun EmptyBook()
{
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center)
    {
      Text(stringResource(id= R.string.empty_book_list_text),
          fontSize = 18.sp
      )
    }
}
