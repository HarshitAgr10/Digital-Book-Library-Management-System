package dev.harshit.exceptions;

/**
 * Custom exception to handle cases when book not found in library
 */
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
}
