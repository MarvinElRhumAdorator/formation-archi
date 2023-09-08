package com.example.domain.exception;

public class AlreadyExistingProductException extends DomainException {
    public AlreadyExistingProductException(long productCode) {
        super("Product with code " + productCode + " already exists");
    }
}
