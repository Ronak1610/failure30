package com.example.failure30.navigation.route

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.failure30.domain.model.toBookDetial
import com.example.failure30.presentation.bookList.ListScreen

@Composable
fun NavGraph(navController: NavHostController,)
{
    NavHost(navController = navController,
        startDestination = BookListScreen.toString()
    ) {
        composable(BookListScreen.toString()) {
         ListScreen(
             modifier = Modifier,
             navigateToBookDetailsScreen = { book ->
                 val bookDetails =  book.toBookDetial()
                 navController.navigate(bookDetails.toString())
             }
         )


        }
    }
}