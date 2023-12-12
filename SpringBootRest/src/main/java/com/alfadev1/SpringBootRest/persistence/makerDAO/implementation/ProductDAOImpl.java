package com.alfadev1.SpringBootRest.persistence.makerDAO.implementation;

import com.alfadev1.SpringBootRest.entity.Product;
import com.alfadev1.SpringBootRest.persistence.makerDAO.IProductDAO;
import com.alfadev1.SpringBootRest.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class ProductDAOImpl implements IProductDAO {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteMakerById(Long id) {
        productRepository.deleteById(id);

    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.findProductsByPriceInRange(minPrice, maxPrice);
    }
}
