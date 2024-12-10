package com.example.failure30.navigation.route

import com.example.failure30.domain.model.BOOK

data class BookDetails(
    val id : Int,
    val tittle : String,
    val author : String
)



fun BookDetails.toBook() = BOOK(
    id = this.id,
    tittle = this.tittle,
    author = this.author

)