package com.alfadev1.SpringBootRest.persistence.entities;
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