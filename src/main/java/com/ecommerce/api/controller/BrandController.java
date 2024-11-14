package com.ecommerce.api.controller;

import com.ecommerce.api.service.BrandApi;
import com.ecommerce.domain.model.Brand;
import com.ecommerce.domain.model.BrandResponse;
import com.ecommerce.application.service.BrandService;
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
@OpenAPIDefinition(servers = {@Server(url = "/ecommerce-brand-service", description = "Ecommerce Brand Service")})
@RequestMapping("/api/brands")
public class BrandController implements BrandApi {

    private final BrandService brandService;

    @GetMapping
    public  ResponseEntity<List<BrandResponse>> getBrands() {
        List<Brand> brands = brandService.getAllBrands();
        List<BrandResponse> brandResponses = brands.stream()
                .map(this::mapBrandToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(brandResponses);
    }

    @Override
    @GetMapping("/{brandId}")
    public ResponseEntity<BrandResponse> getBrand(@PathVariable Long brandId) {
        Brand brand = brandService.getBrandById(brandId);
        BrandResponse brandResponse = mapBrandToResponse(brand);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(brandResponse);
    }

    private BrandResponse mapBrandToResponse(Brand brand) {
        return BrandResponse.builder()
                .id(brand.getId())
                .name(brand.getName())
                .build();
    }
}