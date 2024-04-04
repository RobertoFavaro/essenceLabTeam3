package com.team3.essence.lavib.essence_lab.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Carrello {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  Double prezzoTotale;
    @OneToMany(mappedBy = "profumo")
    private List<Profumo> profumi;

    @OneToMany(mappedBy = "cliente")
    private List<Cliente> cliente;
    public Carrello(){}

    public Carrello(Long id, Double prezzoTotale, List<Profumo> profumi, List<Cliente> cliente) {
        this.id = id;
        this.prezzoTotale = prezzoTotale;
        this.profumi = profumi;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrezzoTotale() {
        return prezzoTotale;
    }

    public void setPrezzoTotale(Double prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }

    public List<Profumo> getProfumi() {
        return profumi;
    }

    public void setProfumi(List<Profumo> profumi) {
        this.profumi = profumi;
    }

    public List<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }
}
