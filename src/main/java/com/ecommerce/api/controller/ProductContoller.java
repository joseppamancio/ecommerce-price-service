package com.ecommerce.api.controller;

import com.ecommerce.api.exception.ResourceNotFoundException;
import com.ecommerce.api.service.ProductApi;
import com.ecommerce.domain.model.Product;
import com.ecommerce.domain.model.ProductRequest;
import com.ecommerce.domain.model.ProductResponse;
import com.ecommerce.domain.repository.ProductRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@OpenAPIDefinition(servers = {@Server(url = "/ecommerce-price-service", description = "Ecommerce Price Service")})
public class ProductContoller implements ProductApi {

    @Autowired
    private ProductRepository productRepository;

    /**
     * This method is used to get a product by id
     *
     * @param id The product id
     * @return The product
     */
    @Override
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            ProductResponse response = ProductResponse.builder()
                    .id(product.get().getId())
                    .name(product.get().getName())
                    .brandId(product.get().getBrandId())
                    .creationDate(product.get().getCreationDate())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Product not found");
        }
    }

    /**
     * This method is used to get all products
     *
     * @return The list of products
     */
    @Override
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponse> response = products.stream()
                .map(product -> ProductResponse.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .brandId(product.getBrandId())
                        .creationDate(product.getCreationDate())
                        .build())
                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * This method is used to update a product
     *
     * @param id ID of the product (required)
     * @param productRequest Product to update (required)
     */
    @Override
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable("id") Long id, @Valid @RequestBody ProductRequest productRequest) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(productRequest.getName());
            product.setBrandId(productRequest.getBrandId());
            productRepository.save(product);

            ProductResponse response = ProductResponse.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .brandId(product.getBrandId())
                    .creationDate(product.getCreationDate())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Product not found");
        }
    }

    /**
     * This method is used to create a product
     *
     * @param productRequest Product to create (required)
     */
    @Override
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .brandId(productRequest.getBrandId())
                .build();
        productRepository.save(product);

        ProductResponse response = ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .brandId(product.getBrandId())
                .creationDate(product.getCreationDate())
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * This method is used to delete a product
     *
     * @param id ID of the product (required)
     */
    @Override
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            productRepository.delete(productOptional.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
                throw new ResourceNotFoundException("Product not found");
        }
    }
}
