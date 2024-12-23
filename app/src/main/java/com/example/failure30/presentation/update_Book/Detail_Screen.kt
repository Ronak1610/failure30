package com.example.failure30.presentation.update_Book

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import com.example.failure30.domain.model.BOOK
import com.example.failure30.presentation.update_Book.Components.Book_Top_Bar
import com.example.failure30.presentation.update_Book.Components.Detail_Compo

@Composable
fun Detail_Screen(book: BOOK,
                  navigateBack : ()-> Unit,)
 {
     Scaffold (topBar = {
         Book_Top_Bar(onArrowBackClick = navigateBack)
     }, content = {
         innerPadding ->
         Detail_Compo(innerPadding = innerPadding,
             book = book)

     },
         modifier = Modifier.windowInsetsPadding(WindowInsets.systemBars)
     )

 }
