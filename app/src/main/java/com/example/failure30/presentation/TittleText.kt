package com.example.failure30.presentation

import androidx.compose.material3.Text
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