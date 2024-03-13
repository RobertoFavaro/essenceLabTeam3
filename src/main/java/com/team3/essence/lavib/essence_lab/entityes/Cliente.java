package com.team3.essence.lavib.essence_lab.entityes;

import jakarta.persistence.*;

@Table
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome_cliente;
    @Column(nullable = false)
    private String cognome_cliente;
    @Column(nullable = false)
    private String genere_cliente;
    @Column(nullable = false, unique = true)
    private String email_cliente;
    @Column(nullable = false, unique = true)
    private String codiceFiscale_cliente;
    @Column(nullable = false)
    private Integer eta_cliente;
    @Column(nullable = false)
    private String indirizzo_cliente;
}
