package com.ecommerce.domain.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Price {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private Long brandId;

    @CreationTimestamp
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;

    @NotBlank
    @Column(nullable = false)
    private int priceList;

    @NotBlank
    @Column(nullable = false)
    private Long productId;

    @Column(columnDefinition = "int default 0")
    private int priority;

    @NotBlank
    @Column(nullable = false)
    private BigDecimal price;

    @Column(columnDefinition = "varchar(255) default 'EUR'")
    private String currency;
}