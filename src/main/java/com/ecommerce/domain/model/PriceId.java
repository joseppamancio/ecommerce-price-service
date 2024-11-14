package com.ecommerce.domain.model;


import jakarta.persistence.Embeddable;
import lombok.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class PriceId implements Serializable {
    private Long brandId;
    private Integer priceList;
    private Long productId;
}
