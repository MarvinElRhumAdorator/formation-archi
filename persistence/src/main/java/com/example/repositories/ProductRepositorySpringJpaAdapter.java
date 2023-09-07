package com.example.repositories;

import com.example.application.gateways.ProductRepository;
import com.example.domain.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositorySpringJpaAdapter implements ProductRepository {
    private final SpringJpaProductRepository repository;

    public ProductRepositorySpringJpaAdapter(SpringJpaProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product registerNew(Product product) {
        ProductJpaMapper productJpaMapper = ProductJpaMapper.fromProduct(product);
        ProductJpaMapper persistedProduct = this.repository.save(productJpaMapper);
        return persistedProduct.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        return this.repository.findAll().stream()
                .map(ProductJpaMapper::toProduct)
                .toList();
    }

    @Override
    public boolean existsProductWithCode(long productCode) {
        return repository.existsByCode(productCode);
    }


    @Override
    public Optional<Product> getProduct(String productId) {
        return repository.findById(productId)
                .map(ProductJpaMapper::toProduct);
    }

    @Override
    public void updateProduct(Product productToRename) {
        ProductJpaMapper productJpaMapper = ProductJpaMapper.fromProduct(productToRename);
        repository.save(productJpaMapper);
    }

}
