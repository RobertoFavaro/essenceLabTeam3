package com.team3.essence.lavib.essence_lab.entities;

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
    @OneToMany(mappedBy = "catalogo")
    private List<Profumo> profumi;
    @ManyToOne
    @JoinColumn(name = "negozio_id")
    private Negozio negozio;

    public Catalogo(){}
    public Catalogo(Long id, String nome_catalogo, Integer capienza_catalogo, List<Profumo> profumi, Negozio negozio) {
        this.id = id;
        this.nome_catalogo = nome_catalogo;
        this.capienza_catalogo = capienza_catalogo;
        this.profumi = profumi;
        this.negozio = negozio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_catalogo() {
        return nome_catalogo;
    }

    public void setNome_catalogo(String nome_catalogo) {
        this.nome_catalogo = nome_catalogo;
    }

    public Negozio getNegozio() {
        return negozio;
    }

    public void setNegozio(Negozio negozio) {
        this.negozio = negozio;
    }

    public Integer getCapienza_catalogo() {
        return capienza_catalogo;
    }

    public void setCapienza_catalogo(Integer capienza_catalogo) {
        this.capienza_catalogo = capienza_catalogo;
    }

    public List<Profumo> getProfumi() {
        return profumi;
    }

    public void setProfumi(List<Profumo> profumi) {
        this.profumi = profumi;
    }
}
