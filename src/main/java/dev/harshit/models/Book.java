package dev.harshit.models;

import java.util.Objects;

/**
 *  Represents a book in the digital library.
 *  Stores details like bookID, title, author, genre, and book availability status.
 *
 */
public class Book {
    private String bookID;

    private String title;

    private String author;

    private String genre;

    private BookAvailabilityStatus bookAvailabilityStatus;

    public Book(String bookID, String title, String author, String genre,
                BookAvailabilityStatus bookAvailabilityStatus) {
        if (bookID == null || bookID.isBlank() || title == null || title.isBlank() ||
                author == null || author.isBlank()) {
            throw new IllegalArgumentException("Book ID, Title, and Author cannot be empty.");
        }

        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookAvailabilityStatus = bookAvailabilityStatus;
    }

    // Getters and Setters methods
    public String getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public BookAvailabilityStatus getBookAvailabilityStatus() {
        return bookAvailabilityStatus;
    }

    public void setBookAvailabilityStatus(BookAvailabilityStatus bookAvailabilityStatus) {
        this.bookAvailabilityStatus = bookAvailabilityStatus;
    }

    // Returns a formatted string representing the book details.
    @Override
    public String toString() {
        return String.format("Book ID: %s | Title: %s | Author %s | Genre: %s | Status: %s",
                bookID, title, author, genre, bookAvailabilityStatus);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Book book = (Book) obj;
        return bookID.equals(book.bookID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookID);
    }
}