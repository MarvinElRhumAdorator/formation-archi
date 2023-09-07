package com.example.application.gateways;

import com.example.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product registerNew(Product product);
    List<Product> getAllProducts();
    boolean existsProductWithCode(long productCode);
    Optional<Product> getProduct(String productId);
    void updateProduct(Product productToRename);
}
