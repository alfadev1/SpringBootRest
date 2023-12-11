package com.alfadev1.SpringBootRest.service.dto;

import com.alfadev1.SpringBootRest.persistence.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MakerInDTO {
    private String name;
    private List<Product> productList;
}
