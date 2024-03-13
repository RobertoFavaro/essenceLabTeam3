package com.team3.essence.lavib.essence_lab.entityes;

import jakarta.persistence.*;

import java.util.List;

@Table
@Entity
public class Negozio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome_negozio;
    @Column(nullable = false)
    private String luogo_negozio;
    @Column(nullable = false, unique = true)
    private String indirizzo_negozio;
    @Column(nullable = false)
    private String partita_iva_negozio;
    @ManyToMany
    private List<Catalogo> lista_di_cataloghi;
}
