package com.ecommerce;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EcommercePriceServiceApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Value("${application.security.username}")
    private String apiUserName;

    @Value("${application.security.password}")
    private String apiUserPassword;

    private HttpEntity<String> createAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(apiUserName, apiUserPassword);
        return new HttpEntity<>(headers);
    }

    @Test
    @DisplayName("Test 1: request at 10:00 on the 14th for product 35455 for brand 1 (ZARA)")
    public void test1() {
        HttpEntity<String> entity = createAuthEntity();
        ResponseEntity<List> response = restTemplate.exchange(
                "/api/prices?productId=35455&brandId=1&applicationDate=2020-06-14-10:00:00",
                HttpMethod.GET, entity, List.class);
        System.out.println("Response: " + response.getBody());
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotEmpty();
    }

    @Test
    @DisplayName("Test 2: request at 16:00 on the 14th for product 35455 for brand 1 (ZARA)")
    public void test2() {
        HttpEntity<String> entity = createAuthEntity();
        ResponseEntity<List> response = restTemplate.exchange(
                "/api/prices?productId=35455&brandId=1&applicationDate=2020-06-14-16:00:00",
                HttpMethod.GET, entity, List.class);
        System.out.println("Response: " + response.getBody());
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotEmpty();
    }

    @Test
    @DisplayName("Test 3: request at 21:00 on the 14th for product 35455 for brand 1 (ZARA)")
    public void test3() {
        HttpEntity<String> entity = createAuthEntity();
        ResponseEntity<List> response = restTemplate.exchange(
                "/api/prices?productId=35455&brandId=1&applicationDate=2020-06-14-21:00:00",
                HttpMethod.GET, entity, List.class);
        System.out.println("Response: " + response.getBody());
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotEmpty();
    }

    @Test
    @DisplayName("Test 4: request at 10:00 on the 15th for product 35455 for brand 1 (ZARA)")
    public void test4() {
        HttpEntity<String> entity = createAuthEntity();
        ResponseEntity<List> response = restTemplate.exchange(
                "/api/prices?productId=35455&brandId=1&applicationDate=2020-06-15-10:00:00",
                HttpMethod.GET, entity, List.class);
        System.out.println("Response: " + response.getBody());
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotEmpty();
    }

    @Test
    @DisplayName("Test 5: request at 21:00 on the 16th for product 35455 for brand 1 (ZARA)")
    public void test5() {
        HttpEntity<String> entity = createAuthEntity();
        ResponseEntity<List> response = restTemplate.exchange(
                "/api/prices?productId=35455&brandId=1&applicationDate=2020-06-16-21:00:00",
                HttpMethod.GET, entity, List.class);
        System.out.println("Response: " + response.getBody());
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotEmpty();
    }
}