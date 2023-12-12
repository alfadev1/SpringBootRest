package com.alfadev1.SpringBootRest.persistence.repository;

import com.alfadev1.SpringBootRest.entity.Maker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakerRepository extends JpaRepository<Maker, Long> {

}
