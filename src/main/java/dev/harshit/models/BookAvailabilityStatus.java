package dev.harshit.models;

/**
 * Enum representing the availability status of a book in the library.
 * Enum because easier to extend in the future if more statuses is required.
 */
public enum BookAvailabilityStatus {
    AVAILABLE,
    CHECKED_OUT;
}
