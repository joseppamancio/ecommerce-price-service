package com.ecommerce.infrastructure.repository;

import com.ecommerce.domain.model.Product;
import com.ecommerce.domain.repository.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductRepository extends JpaRepository<Product, Long>, ProductRepository {
}