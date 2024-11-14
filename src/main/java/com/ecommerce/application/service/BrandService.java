package com.ecommerce.application.service;

import com.ecommerce.api.exception.ResourceNotFoundException;
import com.ecommerce.domain.model.Brand;
import com.ecommerce.domain.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandService {
    private static final Logger logger = LoggerFactory.getLogger(BrandService.class);

    private final BrandRepository brandRepository;

    public Brand getBrandById(Long brandId) {
        logger.info("Fetching brand with id: {}", brandId);
        Optional<Brand> brand = brandRepository.findById(brandId);

        if (brand.isEmpty()) {
            logger.error("No brand found with id: {}", brandId);
            throw new ResourceNotFoundException("No brand found for the given id.");
        }

        logger.info("Brand found: {}", brand.get());
        return brand.get();
    }

    public List<Brand> getAllBrands() {
        logger.info("Fetching all brands");
        List<Brand> brands = brandRepository.findAll();
        logger.info("Brands found: {}", brands);
        return brands;
    }
}