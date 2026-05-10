package com.reservenow.exception;

// Used when a unique resource already exists
public class DuplicateResourceException extends RuntimeException {

    public DuplicateResourceException(String message) {
        super(message);
    }
}

