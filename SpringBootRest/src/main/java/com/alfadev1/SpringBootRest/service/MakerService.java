package com.alfadev1.SpringBootRest.service;


import com.alfadev1.SpringBootRest.persistence.entity.Maker;
import com.alfadev1.SpringBootRest.persistence.makerDAO.IMakerDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MakerService implements IMakerService {

    @Autowired
    private IMakerDAO makerDAO;


    @Override
    public void saveMaker(Maker maker) {
        makerDAO.saveMaker(maker);
    }

    @Override
    public void deleteMakerByID(Long id) {
        makerDAO.deleteMakerByID(id);

    }

    @Override
    public Optional<Maker> findMakerById(Long id) {
        return makerDAO.findMakerById(id);
    }

    @Override
    public List<Maker> findAllMakers() {
        return makerDAO.findAllMakers();
    }
}
