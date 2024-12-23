package com.example.failure30.presentation.bookList.Components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun TittleText(tittle : String)
{
    Text(text = tittle,
        color = Color.DarkGray,
        fontSize = 25.sp)
}