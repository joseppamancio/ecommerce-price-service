package com.ecommerce.api.controller;

import com.ecommerce.api.service.ProductApi;
import com.ecommerce.domain.model.Product;
import com.ecommerce.domain.model.ProductResponse;
import com.ecommerce.application.service.ProductService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@AllArgsConstructor
@OpenAPIDefinition(servers = {@Server(url = "/ecommerce-product-service", description = "Ecommerce Product Service")})
@RequestMapping("/api/products")
public class ProductController implements ProductApi {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductResponse> productResponses = products.stream()
                .map(this::mapProductToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(productResponses);
    }

    @Override
    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long productId) {
        Product product = productService.getProductById(productId);
        ProductResponse productResponse = mapProductToResponse(product);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(productResponse);
    }

    private ProductResponse mapProductToResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .brandId(product.getBrandId())
                .name(product.getName())
                .creationDate(product.getCreationDate())
                .build();
    }
}