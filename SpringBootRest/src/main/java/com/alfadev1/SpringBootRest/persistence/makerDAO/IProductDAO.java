package com.alfadev1.SpringBootRest.persistence.makerDAO;

import com.alfadev1.SpringBootRest.entity.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductDAO {
    void saveProduct(Product product);
    void deleteMakerById(Long id);
    Optional<Product> findProductById(Long id);
    List<Product> findAllProducts();
    List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);
}
