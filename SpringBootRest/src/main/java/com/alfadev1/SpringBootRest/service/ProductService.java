package com.alfadev1.SpringBootRest.service;

import com.alfadev1.SpringBootRest.mapper.ProductInDTOToProduct;
import com.alfadev1.SpringBootRest.persistence.entity.Product;
import com.alfadev1.SpringBootRest.persistence.repository.ProductRepository;
import com.alfadev1.SpringBootRest.service.dto.ProductInDTO;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ProductInDTOToProduct mapper;

    public ProductService(ProductRepository productRepository, ProductInDTOToProduct mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    public Product saveProduct(ProductInDTO productInDTO) {
        Product product = mapper.map(productInDTO);
        return this.productRepository.save(product);
    }
}
