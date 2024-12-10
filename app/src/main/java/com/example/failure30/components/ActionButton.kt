package com.example.failure30.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
 fun ActionButton(onActionClick: ()-> Unit,
                  textResID: Int)
{
Button(onClick = onActionClick) {
    Text(text = stringResource(id = textResID))

}
 }