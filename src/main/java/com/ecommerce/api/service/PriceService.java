package com.ecommerce.api.service;

import com.ecommerce.api.exception.ResourceNotFoundException;
import com.ecommerce.domain.model.Price;
import com.ecommerce.domain.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PriceService {
    private static final Logger logger = LoggerFactory.getLogger(PriceService.class);

    @Autowired
    private PriceRepository priceRepository;

    public Optional<List<Price>> getApplicablePrice(Long productId, Long brandId, OffsetDateTime applicationDate) {
        logger.info("Fetching applicable price for productId: {}, brandId: {}, date: {}", productId, brandId, applicationDate);
        Optional<List<Price>> prices = priceRepository.findApplicablePrice(productId, brandId, applicationDate);

        if (prices.isEmpty()) {
            logger.error("No applicable price found for productId: {}, brandId: {}, date: {}", productId, brandId, applicationDate);
            throw new ResourceNotFoundException("No applicable price found for the given criteria.");
        }

        logger.info("Applicable price found: {}", prices.get());
        return prices;
    }
}