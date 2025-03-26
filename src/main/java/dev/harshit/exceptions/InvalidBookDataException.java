package dev.harshit.exceptions;

/**
 * Custom exception to handle cases when invalid data is passed from view
 */
public class InvalidBookDataException extends RuntimeException {
    public InvalidBookDataException(String message) {
        super(message);
    }
}
