package com.ecommerce.api.controller;


import com.ecommerce.api.service.PingApi;
import com.ecommerce.domain.model.Ping200Response;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@OpenAPIDefinition(servers = {@Server(url = "/ecommerce-price-service", description = "Ecommerce Price Service")})
public class PingController implements PingApi {

    /**
     * This method is used to check the health of the service
     */
    @Override
    public ResponseEntity<Ping200Response> ping() {
        return ResponseEntity.ok(Ping200Response.builder().message("Welcome to Ecommerce Price Service").build());
    }
}
