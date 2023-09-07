package com.example.controller.product.renaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRenamingRestRequest {
    private String id;
    private String name;
}
