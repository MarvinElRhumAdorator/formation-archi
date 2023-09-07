package com.example.repositories;


import com.example.domain.model.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Objects;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class ProductJpaMapper {

    @Id
    @UuidGenerator
    private String id;

    private String name;
    private String description;

    @Column(unique=true)
    private long code;
    private long createdAt;

    public static ProductJpaMapper fromProduct(Product product) {
        return new ProductJpaMapper(
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductJpaMapper that = (ProductJpaMapper) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
