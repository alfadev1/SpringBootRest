package com.alfadev1.SpringBootRest.persistence.dto;

import com.alfadev1.SpringBootRest.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MakerInDTO {
    private Long id;
    private String name;
    private List<Product> productList = new ArrayList<>();
}
