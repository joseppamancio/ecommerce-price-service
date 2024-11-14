package com.ecommerce.domain.model;


import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@IdClass(PriceId.class)
public class Price {

    @Id
    @Column(name = "brand_id", nullable = false)
    private Long brandId;

    @Id
    @NotNull
    @Column(name = "price_list", nullable = false)
    private Integer priceList;

    @Id
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "start_date")
    private OffsetDateTime startDate;

    @Column(name = "end_date")
    private OffsetDateTime endDate;

    @Column(name = "priority", columnDefinition = "int default 0")
    private Integer priority;

    @NotNull
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "currency", columnDefinition = "varchar(255) default 'EUR'")
    private String currency;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}