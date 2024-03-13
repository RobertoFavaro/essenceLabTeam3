package com.team3.essence.lavib.essence_lab.entityes;

import jakarta.persistence.*;

@Table
@Entity
public class Essenza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome_essenza;
    @Column(nullable = false)
    private String allergeni_essenza;
    @Column(nullable = false)
    private Double prezzo_essenza;
    @Column(nullable = false)
    private String ingredienti_essenza;
}
