package com.alfadev1.SpringBootRest.service;

import com.alfadev1.SpringBootRest.mapper.MakerInDTOToMaker;
import com.alfadev1.SpringBootRest.persistence.entity.Maker;
import com.alfadev1.SpringBootRest.persistence.repository.MakerRepository;
import com.alfadev1.SpringBootRest.service.dto.MakerInDTO;
import org.springframework.stereotype.Service;

@Service
public class MakerService {
    private MakerRepository makerRepository;
    private MakerInDTOToMaker mapper;

    public MakerService(MakerRepository makerRepository) {
        this.makerRepository = makerRepository;
        this.mapper = mapper;
    }

    public Maker saveMaker(MakerInDTO makerInDTO) {
        Maker maker = mapper.map(makerInDTO);
        return this.makerRepository.save(maker);
    }

}
