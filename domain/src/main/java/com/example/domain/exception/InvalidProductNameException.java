package com.example.domain.exception;

public class InvalidProductNameException extends DomainException {
    public InvalidProductNameException(String name) {
        super("Name " + name + " is not valid");
    }

}
