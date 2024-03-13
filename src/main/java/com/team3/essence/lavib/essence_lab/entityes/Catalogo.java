package com.team3.essence.lavib.essence_lab.entityes;

import jakarta.persistence.*;

import java.util.List;

@Table
@Entity
public class Catalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome_catalogo;
    @Column(nullable = false)
    private Integer capienza_catalogo;
    @ManyToMany
    private List<Profumo> lista_di_profumi;
}
