package com.example.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringJpaProductRepository extends JpaRepository<ProductJpaMapper, String> {
    boolean existsByCode(long code);
}
