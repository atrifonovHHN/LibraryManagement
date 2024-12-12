package com.example.kotlin_classes.classes.enums

/**
 * Enum class representing various genres of books.
 * Each genre has a description that provides more context about the type of books it includes.
 *
 * @property description A brief explanation of the genre.
 */
enum class Genre(val description: String) {
    FICTION("Imaginative works of narrative, often creative and imaginative."),
    NON_FICTION("Books based on real facts, events, or people."),
    SCIENCE("Books covering scientific topics like physics, biology, or astronomy."),
    HISTORY("Books about historical events, people, and societies."),
    CHILDREN("Books written specifically for children, educational and entertaining.");

    /**
     * Prints the description of the genre.
     *
     * @return A description of the genre.
     */
    fun printDescription() {
        println("Description of $name: $description")
    }
}