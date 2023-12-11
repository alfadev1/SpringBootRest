package com.alfadev1.SpringBootRest.controller;

import com.alfadev1.SpringBootRest.mapper.MakerInDTOToMaker;
import com.alfadev1.SpringBootRest.persistence.entity.Maker;
import com.alfadev1.SpringBootRest.service.MakerService;
import com.alfadev1.SpringBootRest.service.dto.MakerInDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/makers")

public class MakerController {
    private MakerService makerService;
    private MakerInDTOToMaker mapper;

    public MakerController(MakerService makerService, MakerInDTOToMaker mapper) {
        this.makerService = makerService;
        this.mapper = mapper;
    }

    @PostMapping
    public Maker saveMaker(@RequestBody MakerInDTO makerInDTO) {
        return this.makerService.saveMaker(makerInDTO);
    }
}
