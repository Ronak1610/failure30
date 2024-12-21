package com.example.failure30.presentation.update_Book.Components

import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.failure30.R
import com.example.failure30.components.ActionIcon


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Book_Top_Bar(onArrowBackClick : ()-> Unit)
{

    TopAppBar(
        title = {
            Text(text = stringResource(
                id = R.string.book_details_screen_title
            )
            )
        },
        navigationIcon = {
            ActionIcon(onClicker = onArrowBackClick,
                iconResID = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescriptionResID = R.string.navigate_back
            )
        }
    )
}