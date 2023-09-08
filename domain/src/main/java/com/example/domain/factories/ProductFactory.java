package com.example.domain.factories;

import com.example.domain.model.Product;

import java.time.Clock;
import java.time.Instant;

public class ProductFactory {

    private Clock clock;

    public ProductFactory(Clock clock) {
        this.clock = clock;
    }

    public Product create(String name, String description, long code) {
        return new Product(name, description, code, Instant.now(clock).toEpochMilli());
    }
}

