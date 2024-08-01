package com.ecommerce.api.controller;

import com.ecommerce.api.exception.ResourceNotFoundException;
import com.ecommerce.api.service.PriceApi;
import com.ecommerce.domain.model.PriceResponse;
import com.ecommerce.domain.service.PriceService;
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

    /**
     * This method is used to get the applicable price for a given product, brand and application date
     *
     * @param productId       The product id
     * @param brandId         The brand id
     * @param applicationDate The application date
     * @return The applicable price
     */
    @Override
    public ResponseEntity<List<PriceResponse>> getPrices(
            @RequestParam Long productId,
            @RequestParam Long brandId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate applicationDate) {
        OffsetDateTime applicationDateTime = applicationDate.atStartOfDay().atOffset(ZoneOffset.UTC);
        Optional<List<Price>> priceOptional = priceService.getApplicablePrice(productId, brandId, applicationDateTime);

        if (priceOptional.isPresent() && !priceOptional.get().isEmpty()) {
            List<PriceResponse> dataResponses = priceOptional.get().stream()
                    .map(price -> PriceResponse.builder()
                            .brandId(price.getBrandId())
                            .startDate(price.getStartDate())
                            .endDate(price.getEndDate())
                            .priceList(price.getPriceList())
                            .productId(price.getProduct().getId())
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