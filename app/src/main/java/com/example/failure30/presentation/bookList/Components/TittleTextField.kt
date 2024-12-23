package com.example.failure30.presentation.bookList.Components

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue

import com.example.failure30.R

@Composable
fun TittleTestField(tittle : String,
                    onUpdate : (String) -> Unit
)
{
    var tittle1  by remember { mutableStateOf(
        TextFieldValue(text = tittle,
            selection = TextRange(tittle.length)
        )
    )
    }
    val focusRequester = remember { FocusRequester() }
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
    TextField(modifier = Modifier.focusRequester(focusRequester),
        value = tittle1,
        onValueChange = { newTitle ->
            tittle1 = newTitle
            onUpdate(newTitle.text)
        },
        placeholder = {
            Text(
                text = stringResource(R.string.book_title)
            )
        })


}
