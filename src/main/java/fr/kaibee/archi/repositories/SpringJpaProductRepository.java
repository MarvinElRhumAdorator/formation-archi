package fr.kaibee.archi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringJpaProductRepository extends JpaRepository<Product, String> {
    boolean existsByCode(long code);
}
