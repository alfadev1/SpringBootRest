package com.alfadev1.SpringBootRest.persistence.makerDAO;

import com.alfadev1.SpringBootRest.persistence.entity.Maker;

import java.util.List;
import java.util.Optional;

public interface IMakerDAO {
    void saveMaker(Maker maker);
    void deleteMakerByID(Long id);
    Optional<Maker> findMakerById(Long id);
    List<Maker> findAllMakers();
}
