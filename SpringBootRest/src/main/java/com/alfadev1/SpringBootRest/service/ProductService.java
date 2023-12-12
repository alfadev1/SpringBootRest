package com.alfadev1.SpringBootRest.service;


import com.alfadev1.SpringBootRest.entity.Product;
import com.alfadev1.SpringBootRest.persistence.makerDAO.IProductDAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductDAO productDAO;


    @Override
    public void saveProduct(Product product) {
        productDAO.saveProduct(product);

    }

    @Override
    public void deleteMakerById(Long id) {
        productDAO.deleteMakerById(id);

    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return productDAO.findProductById(id);
    }

    @Override
    public List<Product> findAllProducts() {
        return productDAO.findAllProducts();
    }

    @Override
    public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productDAO.findByPriceInRange(minPrice, maxPrice);
    }
}
