package com.example.application.api;

import com.example.application.ProductDto;

import java.util.List;

public interface ProductServiceApi {
    ProductDto createProduct(ProductDto request);

    ProductDto renameProduct(ProductDto request);

    List<ProductDto> findAllProducts();
}
