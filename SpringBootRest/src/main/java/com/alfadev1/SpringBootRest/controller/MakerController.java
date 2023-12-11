package com.alfadev1.SpringBootRest.controller;


import com.alfadev1.SpringBootRest.persistence.entity.Maker;
import com.alfadev1.SpringBootRest.service.IMakerService;

import com.alfadev1.SpringBootRest.service.dto.MakerInDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/makers")

public class MakerController {
    @Autowired
    private IMakerService makerService;


    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Maker> makerOptional = makerService.findMakerById(id);
        if (makerOptional.isPresent()) {
            Maker maker =  makerOptional.get();

            MakerInDTO makerInDTO = MakerInDTO.builder()
                    .id(maker.getId())
                    .name(maker.getName())
                    .productList(maker.getProductList())
                    .build();
            return ResponseEntity.ok(makerInDTO);
        }
        return ResponseEntity.notFound().build();
    }


}
