package com.example.failure30.presentation.bookList.Components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

@Composable
fun AuthorText(text: String)
{
    Text(text = "by $text",
        color = Color.DarkGray,
        fontSize = 12.sp,
        textDecoration = TextDecoration.Underline)
}