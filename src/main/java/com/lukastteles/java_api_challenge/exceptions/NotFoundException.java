package com.lukastteles.java_api_challenge.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {}

    public NotFoundException(final String message) {
        super(message);
    }
}
