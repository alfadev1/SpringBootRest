package com.alfadev1APIREST.SpringBootRest.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "maker")
public class Maker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMaker")
    private Long id;
    private String name;
}
