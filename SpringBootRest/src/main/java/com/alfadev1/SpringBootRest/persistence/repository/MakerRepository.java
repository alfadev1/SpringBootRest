package com.alfadev1.SpringBootRest.persistence.repository;

import com.alfadev1.SpringBootRest.persistence.entity.Maker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MakerRepository extends JpaRepository<Maker, Long> {
}
