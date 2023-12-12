package com.alfadev1.SpringBootRest.controller;

import com.alfadev1.SpringBootRest.entity.Product;
import com.alfadev1.SpringBootRest.persistence.dto.ProductInDTO;
import com.alfadev1.SpringBootRest.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @PostMapping("/saveProduct")
    public ResponseEntity<?> saveProduct(@RequestBody ProductInDTO productInDTO) throws URISyntaxException {
        if (productInDTO.getName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        productService.saveProduct(Product.builder()
                .name(productInDTO.getName())
                .price(productInDTO.getPrice())
                .maker(productInDTO.getMaker())
                .build());
        return ResponseEntity.created(new URI("/products/saveProduct")).build();

    }

    @DeleteMapping("/deleteProductById/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Long id) {
        if (id != null) {
            productService.deleteMakerById(id);
            return ResponseEntity.ok("Register deleted");
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/findAllProducts")
    public ResponseEntity<?> findAllProducts() {
        List<ProductInDTO> productInDTOList = productService.findAllProducts()
                .stream()
                .map(product -> ProductInDTO.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .maker(product.getMaker())
                        .build())
                .toList();
        return ResponseEntity.ok(productInDTOList);
    }

    @GetMapping("/findProductById/{id}")
    public ResponseEntity<?> findProductById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findProductById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            ProductInDTO productInDTO = ProductInDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .maker(product.getMaker())
                    .build();
            return ResponseEntity.ok(productInDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/updateProductById/{id}")
    public ResponseEntity<?> updateProductById(@PathVariable Long id, @RequestBody ProductInDTO productInDTO) {
        Optional<Product> productOptional = productService.findProductById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(productInDTO.getName());
            product.setPrice(productInDTO.getPrice());
            product.setMaker(productInDTO.getMaker());
            productService.saveProduct(product);
            return ResponseEntity.ok("Register updated");
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findProductsByPriceInRange/{minPrice}/{maxPrice}")
    public ResponseEntity<?> findProductsByPriceInRange(@PathVariable BigDecimal minPrice, @PathVariable BigDecimal maxPrice) {
        List<ProductInDTO> productInDTOList = productService.findByPriceInRange(minPrice,maxPrice)
                .stream()
                .map(product -> ProductInDTO.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .maker(product.getMaker())
                        .build())
                .toList();
        return ResponseEntity.ok(productInDTOList);
    }

}























