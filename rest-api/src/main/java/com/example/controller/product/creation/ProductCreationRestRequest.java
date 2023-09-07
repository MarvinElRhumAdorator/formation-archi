package com.example.controller.product.creation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreationRestRequest {
    private String name;
    private String description;
    private long code;
}
