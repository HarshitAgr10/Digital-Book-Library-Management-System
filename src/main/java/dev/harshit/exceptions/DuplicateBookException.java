package dev.harshit.exceptions;

/**
 * Custom exception to handle cases when duplicate book(book already exists) found in library
 */
public class DuplicateBookException extends RuntimeException {
    public DuplicateBookException(String message) {
        super(message);
    }
}
