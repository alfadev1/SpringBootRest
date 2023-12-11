package com.alfadev1.SpringBootRest.persistence.repository;

import com.alfadev1.SpringBootRest.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Long> {
}
