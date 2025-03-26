package dev.harshit.services;
import dev.harshit.exceptions.BookNotFoundException;
import dev.harshit.exceptions.DuplicateBookException;
import dev.harshit.exceptions.InvalidBookDataException;
import dev.harshit.models.Book;
import dev.harshit.models.BookAvailabilityStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service class which contains business logic of application
 * Provides functionalities for adding, viewing, searching, updating, and deleting books.
 */
public class LibraryService {

    // To store books with their unique Book ID as the key.
    private final Map<String, Book> bookList = new HashMap<>();

    /**
     * Adds a new book to the map library.
     * Check if any of parameter is null or blank, throw an exception
     * Check if bookId already exists, throw an exception
     */
    public void addBook(Book book) {
        if (book.getBookID() == null || book.getBookID().isBlank()) {
            throw new InvalidBookDataException("Book ID cannot be null or empty.");
        }
        if (book.getTitle() == null || book.getTitle().isBlank()) {
            throw new InvalidBookDataException("Title cannot be null or empty.");
        }
        if (book.getAuthor() == null || book.getAuthor().isBlank()) {
            throw new InvalidBookDataException("Author cannot be null or empty.");
        }
        if (book.getGenre() == null || book.getGenre().isBlank()) {
            throw new InvalidBookDataException("Genre cannot be null or empty.");
        }
        if (book.getBookAvailabilityStatus() == null) {
            throw new InvalidBookDataException("Book status cannot be null.");
        }
        if (bookList.containsKey(book.getBookID())) {
            throw new DuplicateBookException("Book with ID " + book.getBookID() + " already exists.");
        }

        bookList.put(book.getBookID(), book);
    }

    /**
     * Retrieves a list of all books from map in the arraylist.
     */
    public List<Book> viewAllBooks() {
        return new ArrayList<>(bookList.values());
    }

    /**
     * Searches for a book by its unique bookID.
     * If book not found, throw an exception
     */
    public Book searchBookByID(String bookID) {
        Book book = bookList.get(bookID);
        if (book == null) {
            throw new BookNotFoundException("Book with ID " + bookID + " not found.");
        }
        return book;
    }

    /**
     * Searches for a book by its title.
     * If book not found, throw an exception
     */
    public Book searchBookByTitle(String title) {
        for (Book book : bookList.values()) {
            if (book.getTitle().equals(title)) {
                return book;
            } else {
                throw new BookNotFoundException("Book with title '" + title + "' not found.");
            }
        }
        return null;
    }

    /**
     * Updates the details of an existing book.
     * If book not found, throw an exception
     */
    public Boolean updateBook(String bookId, String title, String author, String genre, BookAvailabilityStatus status) {
        Book book = bookList.get(bookId);
        if (book == null) {
            throw new BookNotFoundException("Book with ID " + bookId + " not found.");
        }

        if (title != null && !title.isBlank()) {
            book.setTitle(title);
        }

        if (author != null && !author.isBlank()) {
            book.setAuthor(author);
        }

        if (genre != null && !genre.isBlank()) {
            book.setGenre(genre);
        }

        if (status != null) {
            book.setBookAvailabilityStatus(status);
        }

        return true;
    }

    /**
     * Deletes a book from the Map.
     * If book not found, throw an exception
     */
    public boolean deleteBook(String bookID) {
        if (!bookList.containsKey(bookID)) {
            throw new BookNotFoundException("Book with ID " + bookID + " not found.");
        }
        return bookList.remove(bookID) != null;
    }
}