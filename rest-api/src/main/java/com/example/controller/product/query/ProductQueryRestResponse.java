package com.example.controller.product.query;

public record ProductQueryRestResponse(String id, String name, String description,
                                       double price, String createdAt) {
}
