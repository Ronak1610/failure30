package com.example.failure30.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.failure30.R
import com.example.failure30.components.ActionIcon
import com.example.failure30.domain.model.BOOK

@Composable
fun BookCard(book: BOOK,
             onBookClick : ()-> Unit ,
             onDeleteClick : ()-> Unit,
             onEditClick : ()-> Unit,
)
{
    Card(modifier = Modifier.fillMaxWidth().padding(
        start = 8.dp,
        top = 4.dp,
        end = 8.dp,
        bottom = 4.dp
    ).clickable { onBookClick() },
        shape = MaterialTheme.shapes.small,
        elevation = CardDefaults.cardElevation(3.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Column ()
            {
                TittleText(tittle = book.tittle)

                AuthorText(text = book.author)
            }
            Spacer(modifier = Modifier.weight(1f))

            ActionIcon(
                onClicker = onEditClick,
                iconResID = Icons.Default.Edit,
                contentDescriptionResID = R.string.edit_icon
            )
            ActionIcon(onClicker = onDeleteClick,
                iconResID = Icons.Default.Delete,
                contentDescriptionResID = R.string.delete_icon)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun BookCardPreview()
{
    BookCard(book = BOOK(1,"The Great Gatsby","F. Scott Fitzgerald"), onBookClick = {}, onDeleteClick = {}, onEditClick = {})
}