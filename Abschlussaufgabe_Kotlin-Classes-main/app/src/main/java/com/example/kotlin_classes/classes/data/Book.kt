package com.example.kotlin_classes.classes.data

import com.example.kotlin_classes.classes.enums.Genre
import com.example.kotlin_classes.classes.sealed_class.BookStatus

data class Book(
    val title: String,
    val author: String,
    val genre: Genre,
    var status: BookStatus,
)