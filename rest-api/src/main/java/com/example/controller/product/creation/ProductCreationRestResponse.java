package com.example.controller.product.creation;

public record ProductCreationRestResponse(String id, String name, String description,
                                          double price, String createdAt) {
}
