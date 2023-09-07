package com.example.application.api.productrenaming;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductRenameInput {
    private String id;
    private String name;
}
