package com.example.failure30.presentation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.example.failure30.R.string.book_list_screen_title

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookTopBar()
{
    TopAppBar(
        title = {
            Text(stringResource(id =book_list_screen_title), style = TextStyle(textDecoration = TextDecoration.Underline), softWrap = false, fontStyle = FontStyle.Italic)
        }
    )
}
@Preview(showBackground = true)
@Composable
fun BookTopBarPreview()
{
    BookTopBar()
}