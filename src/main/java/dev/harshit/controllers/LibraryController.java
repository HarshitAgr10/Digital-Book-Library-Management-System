package dev.harshit.controllers;

import dev.harshit.exceptions.BookNotFoundException;
import dev.harshit.exceptions.InvalidBookDataException;
import dev.harshit.models.Book;
import dev.harshit.models.BookAvailabilityStatus;
import dev.harshit.services.LibraryService;

import java.util.List;

/**
 * Controller class to handle requests from the view
 */
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }


    /**
     * Calls addBook method in libraryService to add a new book to the book library.
     */
    public void addBook(String bookID, String title, String author, String genre, BookAvailabilityStatus bookAvailabilityStatus) {
        try {
            libraryService.addBook(new Book(bookID, title, author, genre, bookAvailabilityStatus));
            System.out.println("Book added successfully!");
        } catch (InvalidBookDataException ex) {
            System.out.println("Invalid Book Data: " + ex.getMessage());
        }
    }


    /**
     * Displays all books in the catalog.
     * Checks if list is empty, if yes display a message otherwise return list of books
     */
    public void viewAllBooks() {
        List<Book> books = libraryService.viewAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }


    /**
     * Searches for a book by bookID.
     */
    public void searchBookByID(String bookID) {
        try {
            Book book = libraryService.searchBookByID(bookID);
            if (book == null) {
                throw new BookNotFoundException("Book with ID " + bookID + " not found.");
            }
            System.out.println(book);
        } catch (BookNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    /**
     * Searches for a book by title.
     */
    public void searchBookByTitle(String bookTitle) {
        try {
            Book book = libraryService.searchBookByTitle(bookTitle);
            if (book == null) {
                throw new BookNotFoundException("Book with title '" + bookTitle + "' not found.");
            }
            System.out.println(book);
        } catch (BookNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    /**
     * Updates the details of an existing book.
     */
    public void updateBook(String bookID, String title, String author, String genre, BookAvailabilityStatus bookAvailabilityStatus) {
        try {
            boolean updated = libraryService.updateBook(bookID, title, author, genre, bookAvailabilityStatus);
            if (!updated) {
                throw new BookNotFoundException("Book with ID " + bookID + " not found.");
            }
            System.out.println("Book updated successfully!");
        } catch (BookNotFoundException | InvalidBookDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    /**
     * Deletes a book from the catalog.
     */
    public void deleteBook(String bookID) {
        try {
            boolean deleted = libraryService.deleteBook(bookID);
            if (!deleted) {
                throw new BookNotFoundException("Book with ID " + bookID + " not found.");
            }
            System.out.println("Book deleted successfully!");
        } catch (BookNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
