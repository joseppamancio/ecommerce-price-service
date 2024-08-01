package com.ecommerce.domain.repository;

import com.ecommerce.domain.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

public interface PriceRepository extends JpaRepository<Price, Long> {

    /**
     * Find the applicable price for a product and brand at a given date
     */
    @Query("SELECT p FROM Price p WHERE p.product.id = :productId AND p.brandId = :brandId AND :applicationDate <= p.endDate AND :applicationDate >= p.startDate ORDER BY p.priority DESC")
    Optional<List<Price>> findApplicablePrice(@Param("productId") Long productId, @Param("brandId") Long brandId, @Param("applicationDate") OffsetDateTime applicationDate);
}