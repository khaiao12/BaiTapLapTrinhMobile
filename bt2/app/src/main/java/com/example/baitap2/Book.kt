package com.example.baitap2

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    var isAvailable: Boolean = true
)