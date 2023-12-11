package com.alfadev1.SpringBootRest.persistence.makerDAO.implementation;

import com.alfadev1.SpringBootRest.persistence.entity.Maker;
import com.alfadev1.SpringBootRest.persistence.makerDAO.IMakerDAO;
import com.alfadev1.SpringBootRest.persistence.repository.MakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component

public class MakerDAOImpl implements IMakerDAO {

    @Autowired
    private MakerRepository makerRepository;

    @Override
    public void saveMaker(Maker maker) {
        makerRepository.save(maker);

    }

    @Override
    public void deleteMakerByID(Long id) {
        makerRepository.deleteById(id);
    }

    @Override
    public Optional<Maker> findMakerById(Long id) {
        return makerRepository.findById(id);
    }

    @Override
    public List<Maker> findAllMakers() {
        return (List<Maker>) makerRepository.findAll();
    }
}
