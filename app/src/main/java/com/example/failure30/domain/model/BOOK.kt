package com.example.failure30.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.failure30.navigation.route.BookDetails

@Entity(tableName = "Book_Table")
data class BOOK(@PrimaryKey (autoGenerate = true)
val id:Int,
    val tittle : String,
    val author : String
)


fun BOOK.toBookDetial() = BookDetails(
    id = this.id,
    tittle = this.tittle,
    author = this.author
)
