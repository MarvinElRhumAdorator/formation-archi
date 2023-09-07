package com.example.application.api.productcreation;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductCreationInput {
    private String name;
    private String description;
    private long code;
}
