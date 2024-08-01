package com.ecommerce.api.controller;

import com.ecommerce.api.exception.ResourceNotFoundException;
import com.ecommerce.api.service.PriceApi;
import com.ecommerce.api.service.PriceService;
import com.ecommerce.domain.model.DataResponse;
import com.ecommerce.domain.model.Price;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@OpenAPIDefinition(servers = {@Server(url = "/ecommerce-price-service", description = "Ecommerce Price Service")})
public class PriceController implements PriceApi {

    @Autowired
    private PriceService priceService;

    @Override
    public ResponseEntity<List<DataResponse>> getPrices(
            @RequestParam Long productId,
            @RequestParam Long brandId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate applicationDate) {
        OffsetDateTime applicationDateTime = applicationDate.atStartOfDay().atOffset(ZoneOffset.UTC);
        Optional<List<Price>> priceOptional = priceService.getApplicablePrice(productId, brandId, applicationDateTime);

        if (priceOptional.isPresent() && !priceOptional.get().isEmpty()) {
            List<DataResponse> dataResponses = priceOptional.get().stream()
                    .map(price -> DataResponse.builder()
                            .brandId(price.getBrandId())
                            .startDate(price.getStartDate())
                            .endDate(price.getEndDate())
                            .priceList(price.getPriceList())
                            .productId(price.getProductId())
                            .priority(price.getPriority())
                            .price(price.getPrice())
                            .currency(price.getCurrency())
                            .build())
                    .collect(Collectors.toList());
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(dataResponses);

        } else {
            throw new ResourceNotFoundException("No applicable price found for the given criteria.");
        }
    }
}