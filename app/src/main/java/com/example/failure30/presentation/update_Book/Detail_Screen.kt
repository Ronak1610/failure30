package com.example.failure30.presentation.update_Book

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
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

     }
     )
 }

@Preview(showBackground = true)
@Composable
fun Detail_ScreenPreview() {
    Detail_Screen(book = BOOK(1, "The Great Gatsby", "F. Scott Fitzgerald"),
        navigateBack = {}
    )
}