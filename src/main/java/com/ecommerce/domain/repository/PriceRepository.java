package com.ecommerce.domain.repository;

import com.ecommerce.domain.model.Price;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

public interface PriceRepository {
    Optional<List<Price>> findApplicablePrice(Long productId, Long brandId, OffsetDateTime applicationDate);
}