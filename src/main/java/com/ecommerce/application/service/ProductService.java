package com.ecommerce.application.service;

import com.ecommerce.api.exception.ResourceNotFoundException;
import com.ecommerce.domain.model.Product;
import com.ecommerce.domain.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    public Product getProductById(Long productId) {
        logger.info("Fetching product with id: {}", productId);
        Optional<Product> product = productRepository.findById(productId);

        if (product.isEmpty()) {
            logger.error("No product found with id: {}", productId);
            throw new ResourceNotFoundException("No product found for the given id.");
        }

        logger.info("Product found: {}", product.get());
        return product.get();
    }

    public List<Product> getAllProducts() {
        logger.info("Fetching all products");
        List<Product> products = productRepository.findAll();
        logger.info("Products found: {}", products);
        return products;
    }
}