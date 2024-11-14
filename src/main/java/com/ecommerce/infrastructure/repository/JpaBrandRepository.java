package com.ecommerce.infrastructure.repository;

import com.ecommerce.domain.model.Brand;
import com.ecommerce.domain.repository.BrandRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBrandRepository extends JpaRepository<Brand, Long>, BrandRepository {
}