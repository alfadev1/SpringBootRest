package com.alfadev1.SpringBootRest.persistence.repository;

import com.alfadev1.SpringBootRest.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long> {

    @Query(value = "SELECT p FROM Product p WHERE p.price BETWEEN ?1 AND ?2", nativeQuery = false )
    List<Product> findProductsByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);
}
