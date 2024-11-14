package com.ecommerce.infrastructure.repository;

import com.ecommerce.domain.model.Price;
import com.ecommerce.domain.model.PriceId;
import com.ecommerce.domain.repository.PriceRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPriceRepository extends JpaRepository<Price, PriceId>, PriceRepository {

    @Override
    @Query("SELECT p FROM Price p WHERE p.id.productId = :productId AND p.id.brandId = :brandId AND :applicationDate <= p.endDate AND :applicationDate >= p.startDate ORDER BY p.priority DESC")
    Optional<List<Price>> findApplicablePrice(@Param("productId") Long productId, @Param("brandId") Long brandId, @Param("applicationDate") OffsetDateTime applicationDate);
}