package com.example.repositories;


import com.example.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringJpaProductRepository extends JpaRepository<Product, String> {
    boolean existsByCode(long code);
}
