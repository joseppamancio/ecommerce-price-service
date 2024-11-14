package com.ecommerce;


import com.ecommerce.api.exception.ErrorDetails;
import com.ecommerce.api.exception.GlobalExceptionHandler;
import com.ecommerce.api.exception.ResourceNotFoundException;
import com.ecommerce.domain.model.BrandResponse;
import com.ecommerce.domain.model.ProductResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EcommercePriceServiceApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Value("${application.security.username}")
    private String apiUserName;

    @Value("${application.security.password}")
    private String apiUserPassword;

    @Mock
    private WebRequest webRequest;

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    private HttpEntity<String> createAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(apiUserName, apiUserPassword);
        return new HttpEntity<>(headers);
    }

    @Test
    @DisplayName("Test 0: ping")
    public void test0() {
        HttpEntity<String> entity = createAuthEntity();
        ResponseEntity<String> response = restTemplate.exchange("/ping", HttpMethod.GET, entity, String.class);
        System.out.println("Response: " + response.getBody());
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo("{\"message\":\"Welcome to Ecommerce Price Service\"}");
    }

    @Test
    @DisplayName("Test 1: request at 10:00 on the 14th for product 35455 for brand 1 (ZARA)")
    public void test1() {
        HttpEntity<String> entity = createAuthEntity();
        String applicationDate = "2020-06-14-10:00:00";
        String productId = "35455";
        String brandId = "1";

        String url = String.format("/api/prices?productId=%s&brandId=%s&applicationDate=%s",
                productId, brandId, applicationDate);
        ResponseEntity<List> response = restTemplate.exchange(url, HttpMethod.GET, entity, List.class);
        System.out.println("Response: " + response.getBody());
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotEmpty();
    }

    @Test
    @DisplayName("Test 2: request at 16:00 on the 14th for product 35455 for brand 1 (ZARA)")
    public void test2() {
        HttpEntity<String> entity = createAuthEntity();
        String applicationDate = "2020-06-14-16:00:00";
        String productId = "35455";
        String brandId = "1";

        String url = String.format("/api/prices?productId=%s&brandId=%s&applicationDate=%s",
                productId, brandId, applicationDate);
        ResponseEntity<List> response = restTemplate.exchange(url, HttpMethod.GET, entity, List.class);
        System.out.println("Response: " + response.getBody());
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotEmpty();
    }

    @Test
    @DisplayName("Test 3: request at 21:00 on the 14th for product 35455 for brand 1 (ZARA)")
    public void test3() {
        HttpEntity<String> entity = createAuthEntity();
        String applicationDate = "2020-06-14-21:00:00";
        String productId = "35455";
        String brandId = "1";

        String url = String.format("/api/prices?productId=%s&brandId=%s&applicationDate=%s",
                productId, brandId, applicationDate);
        ResponseEntity<List> response = restTemplate.exchange(url, HttpMethod.GET, entity, List.class);
        System.out.println("Response: " + response.getBody());
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotEmpty();
    }

    @Test
    @DisplayName("Test 4: request at 10:00 on the 15th for product 35455 for brand 1 (ZARA)")
    public void test4() {
        HttpEntity<String> entity = createAuthEntity();
        String applicationDate = "2020-06-15-10:00:00";
        String productId = "35455";
        String brandId = "1";

        String url = String.format("/api/prices?productId=%s&brandId=%s&applicationDate=%s",
                productId, brandId, applicationDate);
        ResponseEntity<List> response = restTemplate.exchange(url, HttpMethod.GET, entity, List.class);
        System.out.println("Response: " + response.getBody());
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotEmpty();
    }

    @Test
    @DisplayName("Test 5: request at 21:00 on the 16th for product 35455 for brand 1 (ZARA)")
    public void test5() {
        HttpEntity<String> entity = createAuthEntity();
        String applicationDate = "2020-06-16-21:00:00";
        String productId = "35455";
        String brandId = "1";

        String url = String.format("/api/prices?productId=%s&brandId=%s&applicationDate=%s",
                productId, brandId, applicationDate);
        ResponseEntity<List> response = restTemplate.exchange(url, HttpMethod.GET, entity, List.class);
        System.out.println("Response: " + response.getBody());
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotEmpty();
    }

    @Test
    @DisplayName("Test 6: request all products")
    public void test6() {
        HttpEntity<String> entity = createAuthEntity();
        ResponseEntity<List> response = restTemplate.exchange("/api/products", HttpMethod.GET, entity, List.class);
        System.out.println("Response: " + response.getBody());
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotEmpty();
    }

    @Test
    @DisplayName("Test 7: request product by id")
    public void test7() {
        HttpEntity<String> entity = createAuthEntity();
        String productId = "35455";
        String url = String.format("/api/products/%s", productId);
        ResponseEntity<ProductResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, ProductResponse.class);
        System.out.println("Response: " + response.getBody());
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
    }

    @Test
    @DisplayName("Test 8: request all brands")
    public void test8() {
        HttpEntity<String> entity = createAuthEntity();
        ResponseEntity<List> response = restTemplate.exchange("/api/brands", HttpMethod.GET, entity, List.class);
        System.out.println("Response: " + response.getBody());
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotEmpty();
    }

    @Test
    @DisplayName("Test 9: request brand by id")
    public void test9() {
        HttpEntity<String> entity = createAuthEntity();
        String brandId = "1";
        String url = String.format("/api/brands/%s", brandId);
        ResponseEntity<BrandResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, BrandResponse.class);
        System.out.println("Response: " + response.getBody());
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
    }


    @Test
    @DisplayName("Test 10: exception Handling")
    public void testExceptionHandling() {
        String productId = "99999"; // Non-existent product ID
        String url = String.format("/api/prices?productId=%s&brandId=%s&applicationDate=%s", productId, "1", "2020-06-15-10:00:00");
        when(webRequest.getDescription(false)).thenReturn("uri=/api/prices?productId=99999&brandId=1&applicationDate=2020-06-15-10:00:00");

        try {
            restTemplate.exchange(url, HttpMethod.GET, createAuthEntity(), ErrorDetails.class);
        } catch (ResourceNotFoundException ex) {
            ResponseEntity<ErrorDetails> responseEntity = globalExceptionHandler.resourceNotFoundException(ex, webRequest);

            assertThat(responseEntity.getStatusCode().value()).isEqualTo(404);
            assertThat(responseEntity.getBody()).isNotNull();
            assertThat(responseEntity.getBody().getMessage()).isEqualTo("Resource not found");
            assertThat(responseEntity.getBody().getDetails()).isEqualTo("uri=/api/prices?productId=99999&brandId=1&applicationDate=2020-06-15-10:00:00");
        }
    }
}