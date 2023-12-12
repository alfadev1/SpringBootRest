package com.alfadev1.SpringBootRest.persistence.dto;

import com.alfadev1.SpringBootRest.entity.Maker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductInDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private Maker maker;
}
