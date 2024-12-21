package com.example.failure30.presentation.update_Book.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.failure30.domain.model.BOOK
import com.example.failure30.presentation.bookList.Components.AuthorText
import com.example.failure30.presentation.bookList.Components.TittleText

@Composable
fun Detail_Compo(innerPadding : PaddingValues,
                  book: BOOK)
{
    Column (modifier = Modifier.fillMaxSize().
    padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        TittleText(
            tittle = book.tittle
        )
        Spacer(modifier = Modifier.padding(8.dp))
        AuthorText(
            text = book.author
        )

    }

}
