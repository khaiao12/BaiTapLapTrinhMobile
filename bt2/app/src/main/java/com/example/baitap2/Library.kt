package com.example.baitap2

class Library {
    private val books = mutableListOf<Book>()
    private val users = mutableListOf<User>()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun addUser(user: User) {
        users.add(user)
    }

    fun borrowBook(userId: Int, bookId: Int): String {
        val user = users.find { it.id == userId }
        val book = books.find { it.id == bookId }

        return if (user != null && book != null && book.isAvailable) {
            book.isAvailable = false
            "User ${user.name} borrowed '${book.title}'."
        } else {
            "Cannot borrow the book."
        }
    }

    fun showBooks(): List<Book> {
        return books
    }
}
