package com.example.application.internal;


import com.example.application.DateUtils;
import com.example.application.ProductDto;
import com.example.application.api.ProductServiceApi;
import com.example.application.gateways.ProductRepository;
import com.example.domain.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ProductService implements ProductServiceApi {
    @Autowired
    private ProductRepository repository;

    @Override
    public ProductDto createProduct(ProductDto request) {
        long productCode = request.getCode();
        if (repository.existsProductWithCode(productCode)) {
            throw new RuntimeException("already existing" + productCode);
        }
        String name = request.getName();

        if (name == null || name.length() < 5) {
            throw new RuntimeException("invalid name");
        }
        Product product = new Product(null, request.getName(), request.getDescription(), productCode, Instant.now().toEpochMilli());

        Product createdProduct = repository.registerNew(product);

        return toDto(createdProduct);
    }

    @Override
    public ProductDto renameProduct(ProductDto request) {
        String productId = request.getId();

        Product productToRename = repository.getProduct(productId)
                .orElseThrow(() -> new RuntimeException("not existing " + productId));

        String name = request.getName();

        if (name == null || name.length() < 5) {
            throw new RuntimeException("invalid name");
        }

        productToRename.setName(request.getName());

        repository.updateProduct(productToRename);

        return toDto(productToRename);
    }

    @Override
    public List<ProductDto> findAllProducts() {
        return repository.getAllProducts().stream().map(ProductService::toDto).toList();
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
