package com.example.failure30.components

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource

@Composable
fun ActionIcon(onClicker : ()-> Unit,
               iconResID : ImageVector,
               contentDescriptionResID : Int)
{ IconButton(onClick = onClicker) {
   Icon(imageVector = iconResID,
       contentDescription = stringResource(id= contentDescriptionResID)
   )
   }

}