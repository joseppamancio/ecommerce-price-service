package com.ecommerce.domain.model;


import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
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
    @Column(name = "brand_id", nullable = false)
    private Long brandId;

    @CreationTimestamp
    @Column(name = "start_date")
    private OffsetDateTime startDate;

    @Column(name = "end_date")
    private OffsetDateTime endDate;

    @NotBlank
    @Column(name = "price_list", nullable = false)
    private int priceList;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "priority", columnDefinition = "int default 0")
    private int priority;

    @NotBlank
    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "currency", columnDefinition = "varchar(255) default 'EUR'")
    private String currency;

    /**
     * This method is used to convert the object to a string
     *
     * @return The object as a string
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}