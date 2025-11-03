package com.example.demo_query_dsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_query_dsl.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, ProductQueryDslRepository {
    List<Product> findByTitleContaining(String Title);
    List<Product> findByDescriptionContaining(String description);
    List<Product> findByTitleContainingOrDescriptionContaining(String title, String description);
}
