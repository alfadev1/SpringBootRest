package com.alfadev1.SpringBootRest.controller;

import com.alfadev1.SpringBootRest.entity.Maker;
import com.alfadev1.SpringBootRest.service.IMakerService;
import com.alfadev1.SpringBootRest.persistence.dto.MakerInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/makers")

public class MakerController {
    @Autowired
    private IMakerService makerService;



    @GetMapping("/findMakerById/{id}")
    public ResponseEntity<?> findMakerById(@PathVariable Long id) {
        Optional<Maker> makerOptional = makerService.findMakerById(id);
        if (makerOptional.isPresent()) {
            Maker maker = makerOptional.get();

            MakerInDTO makerInDTO = MakerInDTO.builder()
                    .id(maker.getId())
                    .name(maker.getName())
                    .productList(maker.getProductList())
                    .build();
            return ResponseEntity.ok(makerInDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAllMakers")
    public ResponseEntity<?> findAllMakers() {
        List<MakerInDTO> makerInDTOList = makerService.findAllMakers()
                .stream()
                .map(maker -> MakerInDTO.builder()
                        .id(maker.getId())
                        .name(maker.getName())
                        .productList(maker.getProductList())
                        .build())
                .toList();
        return ResponseEntity.ok(makerInDTOList);
    }

    @PostMapping("/saveMaker")
    public ResponseEntity<?> saveMaker(@RequestBody MakerInDTO makerInDTO) throws URISyntaxException {
        if (makerInDTO.getName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        makerService.saveMaker(Maker.builder()
                .name(makerInDTO.getName())
                .build());

        return ResponseEntity.created(new URI("/makers/saveMaker")).build();
    }

    @PutMapping("/updateMaker/{id}")
    public ResponseEntity<?> updateMaker(@PathVariable Long id, @RequestBody MakerInDTO makerInDTO) {
        Optional<Maker> makerOptional = makerService.findMakerById(id);
        if (makerOptional.isPresent()) {
            Maker maker = makerOptional.get();
            maker.setName(makerInDTO.getName());
            makerService.saveMaker(maker);
            return ResponseEntity.ok("Register updated");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteMakerById/{id}")
    public ResponseEntity<?> deleteMakerById(@PathVariable Long id) {
        if (id != null) {
            makerService.deleteMakerByID(id);
            return ResponseEntity.ok("Register deleted");
        }
        return ResponseEntity.badRequest().build();
    }


}
