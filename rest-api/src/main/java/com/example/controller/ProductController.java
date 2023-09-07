package com.example.controller;

import com.example.application.ProductDto;
import com.example.application.api.ProductServiceApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@Slf4j
public class ProductController {

    @Autowired
    private ProductServiceApi productServiceApi;

    @PostMapping
    public ProductDto create(@RequestBody ProductDto request) {
        log.info("in controller");
        return this.productServiceApi.createProduct(request);
    }

    @PatchMapping
    public ProductDto rename(@RequestBody ProductDto request) {
        return this.productServiceApi.renameProduct(request);
    }

    @GetMapping
    public List<ProductDto> findProducts() {
        return productServiceApi.findAllProducts();
    }
}




