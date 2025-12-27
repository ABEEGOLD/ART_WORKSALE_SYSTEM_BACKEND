package com.semicolon.africa.exceptions;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(String invalidEmailOrPassword) {
        super(invalidEmailOrPassword);
    }
}
