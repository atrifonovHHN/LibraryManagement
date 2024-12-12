package com.example.kotlin_classes

import com.example.kotlin_classes.classes.data.Book
import com.example.kotlin_classes.classes.enums.Genre
import com.example.kotlin_classes.classes.nested_inner.Library
import com.example.kotlin_classes.classes.sealed_class.Available

/**
 * The Main class contains the entry point for the application and demonstrates the functionality of the Library system.
 */
class Main {

    /**
     * The run function sets up the library, adds books, creates members, and displays the results.
     */
    fun run() {
        // Create library and address
        val library = Library()

        // Create books with status
        val book1 = Book("Kotlin for Beginners", "John Doe", Genre.FICTION, Available("Kotlin for Beginners"))
        val book2 = Book("Android Development", "Jane Smith", Genre.NON_FICTION, Available("Android Development"))
        val book3 = Book("The Kotlin Language", "Bruce Eckel", Genre.SCIENCE, Available("The Kotlin Language"))

        // Add books to the library
        library.addBook(book1)
        library.addBook(book2)
        library.addBook(book3)

        // Define the library's address
        val address = Library.LibraryAddress("Main St. 123", "Sample City", "12345")
        address.printAddress()  // Print the address

        // Create a library member
        val member = library.LibraryMember("Max Mustermann", 101)

        // Member checks out one book and reserves another
        member.checkoutBook(book1, "2024-12-15") // Check out book1
        member.reserveBook(book2) // Reserve book2

        // Display the status of the books
        println("\nCurrent status of the books:")
        library.displayBookStatuses()

        // Another member and book checkout
        val member2 = library.LibraryMember("Erika Musterfrau", 102)
        member2.checkoutBook(book3, "2024-12-20") // Check out book3

        // Updated status after book checkout
        println("\nUpdated status of the books after member 2 checks out a book:")
        library.displayBookStatuses()

        // Search for books
        println("\nSearch results for 'Kotlin':")
        val searchResults = library.searchBooks("Kotlin")
        for (book in searchResults) {
            println(book.title)
        }
    }
}

/**
 * main function is the entry point of the application.
 * It creates an instance of the Main class and calls the `run` function to execute the program.
 */
fun main() {
    val mainApp = Main() // Create an instance of the com.example.kotlin_classes.Main class
    mainApp.run() // Call the run() method to execute the program
}
