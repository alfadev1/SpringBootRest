package com.alfadev1.SpringBootRest.controller;

import com.alfadev1.SpringBootRest.persistence.entity.Product;
import com.alfadev1.SpringBootRest.service.ProductService;
import com.alfadev1.SpringBootRest.service.dto.ProductInDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @PostMapping
    public Product saveProduct(@RequestBody ProductInDTO productInDTO) {
        return this.productService.saveProduct(productInDTO);
    }
}
