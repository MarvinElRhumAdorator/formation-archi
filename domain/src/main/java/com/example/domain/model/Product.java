package com.example.domain.model;

import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode(of = {"code"})
public class Product {

    private String id;

    private String name;
    private String description;

    private long code;
    private long createdAt;

    public static Product fromProduct(Product product) {
        return new Product(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getCode(),
                product.getCreatedAt());
    }

    public Product toProduct() {
        return new Product(
                this.getId(),
                this.getName(),
                this.getDescription(),
                this.getCode(),
                this.getCreatedAt());
    }

}
