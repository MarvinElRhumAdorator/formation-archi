package com.example.domain.model;


import com.example.domain.exception.InvalidProductNameException;

public class Product {
    private String id;
    private String name;
    private String description;
    private long code;
    private long createdAt;

    private static final int MINIMUM_CHARACTER_LIMIT = 5;

    public Product(String id, String name, String description, long code, long createdAt) {
        this.id = id;
        setName(name);
        this.description = description;
        this.code = code;
        this.createdAt = createdAt;
    }

    public Product(String name, String description, long code, long createdAt) {
        this(null, name, description, code, createdAt);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        if (!nameIsValid(name)) {
            throw new InvalidProductNameException(name);
        }
        this.name = name;
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public long getCode() {
        return code;
    }

    public boolean nameIsValid(String name) {
        return name != null && name.length() >= MINIMUM_CHARACTER_LIMIT;
    }
}
