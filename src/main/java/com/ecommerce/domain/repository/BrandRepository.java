package com.ecommerce.domain.repository;

import com.ecommerce.domain.model.Brand;
import java.util.List;
import java.util.Optional;

public interface BrandRepository {
    Optional<Brand> findById(Long brandId);
    List<Brand> findAll();
}
