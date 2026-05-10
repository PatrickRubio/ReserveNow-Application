package com.reservenow.exception;

// Exception when requested resource does not exist
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}