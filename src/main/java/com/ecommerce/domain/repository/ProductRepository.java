package com.ecommerce.domain.repository;

import com.ecommerce.domain.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findById(Long productId);
    List<Product> findAll();
}
