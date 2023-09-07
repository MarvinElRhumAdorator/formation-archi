package fr.kaibee.archi.controllers;

import fr.kaibee.archi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductDto create(@RequestBody ProductDto request) {
        return this.productService.createProduct(request);
    }

    @PatchMapping
    public ProductDto rename(@RequestBody ProductDto request) {
        return this.productService.renameProduct(request);
    }

    @GetMapping
    public List<ProductDto> findProducts() {
        return productService.findAllProducts();
    }
}




