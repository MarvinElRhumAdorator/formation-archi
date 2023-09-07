package com.example.application;


import com.example.domain.model.Product;
import com.example.repositories.SpringJpaProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private SpringJpaProductRepository repository;

    public ProductDto createProduct(ProductDto request) {
        long productCode = request.getCode();
        if (repository.existsByCode(productCode)) {
            throw new RuntimeException("already existing" + productCode);
        }
        String name = request.getName();

        if (name == null || name.length() < 5) {
            throw new RuntimeException("invalid name");
        }
        Product product = new Product(null, request.getName(), request.getDescription(), productCode, Instant.now().toEpochMilli());

        Product createdProduct = repository.save(product);

        return toDto(createdProduct);
    }

    public ProductDto renameProduct(ProductDto request) {
        String productId = request.getId();

        Product productToRename = repository.findById(productId)
                .orElseThrow(() -> new RuntimeException("not existing " + productId));

        String name = request.getName();

        if (name == null || name.length() < 5) {
            throw new RuntimeException("invalid name");
        }

        productToRename.setName(request.getName());

        repository.save(productToRename);

        return toDto(productToRename);
    }

    public List<ProductDto> findAllProducts() {
        return repository.findAll().stream().map(ProductService::toDto).toList();
    }

    private static ProductDto toDto(Product createdProduct) {
        return new ProductDto(
                createdProduct.getId(),
                createdProduct.getName(),
                createdProduct.getCode(),
                createdProduct.getDescription(),
                DateUtils.dateToString(createdProduct.getCreatedAt()));
    }

}
