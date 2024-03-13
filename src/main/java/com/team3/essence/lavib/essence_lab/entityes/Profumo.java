package com.team3.essence.lavib.essence_lab.entityes;

import com.team3.essence.lavib.essence_lab.Enum.EnumTipoProfumo;
import jakarta.persistence.*;

import java.util.List;

@Table
@Entity
public class Profumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome_profumo;
    @Column(nullable = false)
    private String marca_profumo;
    @Column(nullable = false)
    private String descrizione_profumo;
    @Column(nullable = false)
    private String ingredienti_profumo;
    @Column(nullable = false)
    private Double prezzo_profumo;
    @Column(nullable = false)
    private String allergeni_profumo;
    @ManyToMany
    private List<Essenza> lista_di_essenze;
    private EnumTipoProfumo enumTipoProfumo;
}
