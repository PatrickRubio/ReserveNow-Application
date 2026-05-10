package com.reservenow.exception;

// Used when a request violates application business rules
public class BusinessRuleException extends RuntimeException {

    public BusinessRuleException(String message) {
        super(message);
    }
}