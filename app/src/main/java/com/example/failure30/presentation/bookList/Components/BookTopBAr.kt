package com.example.failure30.presentation.bookList.Components


import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration

import com.example.failure30.R.string.book_list_screen_title

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BookTopBar()
{
    TopAppBar(
        title = {
            Text(stringResource(id =book_list_screen_title), style = TextStyle(textDecoration = TextDecoration.Underline), softWrap = false, fontStyle = FontStyle.Italic)
        }
    )
}
