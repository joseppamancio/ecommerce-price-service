package com.ecommerce.api.exception;


/**
 * This Exception class will be thrown when a resource is not found in the database.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
