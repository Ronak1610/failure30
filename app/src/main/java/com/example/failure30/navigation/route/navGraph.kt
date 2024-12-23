package com.example.failure30.navigation.route


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.failure30.domain.model.toBookDetial
import com.example.failure30.presentation.bookList.ListScreen
import com.example.failure30.presentation.update_Book.Detail_Screen

@Composable
fun NavGraph(navController: NavHostController)
{
    NavHost(navController = navController,
        startDestination = BookListScreen
    ) {
        composable<BookListScreen> {
ListScreen(
    navigateToBookDetailsScreen = { books1 ->
        val bookDetails = books1.toBookDetial()
        navController.navigate(bookDetails)
    }

)

        }
        composable<BookDetails> {entry ->
            val bookDetails = entry.toRoute<BookDetails>()
            val book = bookDetails.toBook()
            Detail_Screen(
                book = book,
                navigateBack = navController:: navigateUp
            )

        }
    }
}