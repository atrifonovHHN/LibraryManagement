package com.example.kotlin_classes.classes.sealed_class

/**
 * A sealed class representing the different states a book can be in within the library system.
 */
sealed class BookStatus {

    /**
     * Prints the status of the book.
     *
     * @return A string representing the status of the book.
     */
    abstract fun printStatus(): String
}

/**
 * Represents a book that is available for checkout.
 *
 * @property bookName The name of the book.
 */
data class Available(val bookName: String) : BookStatus() {
    /**
     * Returns a string indicating that the book is available.
     *
     * @return A string with the book's availability status.
     */
    override fun printStatus(): String {
        return "$bookName is available."
    }
}

/**
 * Represents a book that has been checked out by a library member.
 *
 * @property bookName The name of the book.
 * @property dueDate The due date for returning the book.
 */
data class CheckedOut(val bookName: String, val dueDate: String) : BookStatus() {
    /**
     * Returns a string indicating that the book is checked out and provides the due date.
     *
     * @return A string with the book's checked-out status and due date.
     */
    override fun printStatus(): String {
        return "$bookName is loaned out. Return date: $dueDate"
    }
}

/**
 * Represents a book that has been reserved by a library member.
 *
 * @property bookName The name of the book.
 * @property reservedBy The name of the person who reserved the book.
 */
data class Reserved(val bookName: String, val reservedBy: String) : BookStatus() {
    /**
     * Returns a string indicating that the book is reserved by a specific member.
     *
     * @return A string with the book's reservation status and the name of the person who reserved it.
     */
    override fun printStatus(): String {
        return "$bookName is reserved by $reservedBy"
    }
}
