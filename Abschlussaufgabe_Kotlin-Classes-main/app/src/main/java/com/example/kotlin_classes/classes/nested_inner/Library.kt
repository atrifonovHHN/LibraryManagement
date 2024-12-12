package com.example.kotlin_classes.classes.nested_inner

import com.example.kotlin_classes.classes.data.Book
import com.example.kotlin_classes.classes.sealed_class.CheckedOut
import com.example.kotlin_classes.classes.sealed_class.Reserved

/**
 * Represents a library that holds books and has members who can borrow and reserve books.
 *
 * @property books A list of books that the library currently holds.
 * @property members A list of library members who can borrow or reserve books.
 */
class Library {

    private val books = mutableListOf<Book>()
    private val members = mutableListOf<LibraryMember>()

    /**
     * Represents the address of the library.
     *
     * @property street The street name of the library's location.
     * @property city The city where the library is located.
     * @property zipCode The zip code for the library's location.
     */
    class LibraryAddress(
        private val street: String,
        private val city: String,
        private val zipCode: String
    ) {
        /**
         * Prints the full address of the library.
         */
        fun printAddress() {
            println("Library address: $street, $city, $zipCode")
        }
    }

    /**
     * Represents a library member who can borrow or reserve books.
     *
     * @property name The name of the library member.
     * @property memberID A unique ID for the library member.
     */
    inner class LibraryMember(
        private val name: String,
        private val memberID: Int
    ) {

        /**
         * Allows a member to check out a book and sets the due date.
         *
         * @param book The book to check out.
         * @param dueDate The due date for returning the book.
         */
        fun checkoutBook(book: Book, dueDate: String) {
            book.status = CheckedOut(book.title, dueDate)
        }

        /**
         * Allows a member to reserve a book.
         *
         * @param book The book to reserve.
         */
        fun reserveBook(book: Book) {
            book.status = Reserved(book.title, name)
        }
    }

    /**
     * Adds a book to the library's collection.
     *
     * @param book The book to add to the library.
     */
    fun addBook(book: Book) {
        books.add(book)
    }

    /**
     * Searches for books in the library based on the title or author.
     *
     * @param query The search term (either a part of the book title or author name).
     * @return A list of books matching the search criteria.
     */
    fun searchBooks(query: String): List<Book> {
        return books.filter {
            it.title.contains(query, ignoreCase = true) || it.author.contains(
                query,
                ignoreCase = true
            )
        }
    }

    /**
     * Displays the status of all books in the library, printing whether they are available, checked out, or reserved.
     */
    fun displayBookStatuses() {
        for (book in books) {
            println(book.status.printStatus())
        }
    }
}
