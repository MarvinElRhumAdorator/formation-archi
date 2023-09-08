package com.example.domain.exception;

public class NonExistingProductException extends DomainException {
    public NonExistingProductException(String id) {
        super("Product with id " + id + " does not exist");
    }
}
