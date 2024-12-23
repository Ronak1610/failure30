@file:Suppress("DEPRECATION")

package com.example.failure30.presentation.bookList.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.unit.dp
import com.example.failure30.R
import com.example.failure30.components.ActionButton
import com.example.failure30.domain.model.BOOK

const val EmptyString = ""
@OptIn(ExperimentalMaterialApi::class)
@ExperimentalMaterialApi
@Composable
fun InsertAlertDialog(
    onEmptyTittle : ()-> Unit,
    onEmptyAuthor : ()-> Unit,
    onInsertBox : (book : BOOK)-> Unit,
    onCancel : () -> Unit
)
{
    var tittle by remember { mutableStateOf(EmptyString) }
    var author by remember { mutableStateOf(EmptyString) }

       AlertDialog(
    onDismissRequest = { onCancel() },
    title = {
        Text(
        text = stringResource(
            id = R.string.insert_book)
    )
            },
           text = {
               Column()
               {
                   TittleTestField(tittle = tittle,
                       onUpdate = {
                           newTitle ->
                          tittle = newTitle
                       })
                   Spacer(modifier = Modifier.height(16.dp))
                   AuthorTextField(author = author,
                       onAuthorChange = { newAuthor ->
                           author= newAuthor
                       }
                   )
               }
           },
           confirmButton = {
               ActionButton(
                   onActionClick = {
                       if (tittle.isEmpty())
                       {
                           onEmptyTittle()
                           return@ActionButton
                       }
                       if (author.isEmpty())
                       {
                           onEmptyAuthor()
                           return@ActionButton

                       }
                       onInsertBox(BOOK(
                           id = 0,
                           tittle = tittle,
                           author = author
                       ))
                       onCancel()
                   },
             textResID = R.string.insert_button
               )
           },
           dismissButton = {
               ActionButton(
                   onActionClick = onCancel,
                 textResID = R.string.cancel_button
               )
           }

)
}
