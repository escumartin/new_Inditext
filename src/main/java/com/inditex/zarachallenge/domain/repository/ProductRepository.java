package com.inditex.zarachallenge.domain.repository;

import com.inditex.zarachallenge.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);

    List<Product> findAll();

    @Query("SELECT p FROM Product p WHERE p.id <> :productId")
    List<Product> findSimilarProductIds(Long productId);
}
