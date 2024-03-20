package com.team3.essence.lavib.essence_lab.entities;

import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.lang.NonNull;

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
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "record_status", nullable = false, length = 1)
    private RecordStatusEnum recordStatusEnum =  RecordStatusEnum .A;

    public Cliente(){}
    public Cliente(Long id, String nome_cliente, String cognome_cliente, String genere_cliente, String email_cliente, String codiceFiscale_cliente, Integer eta_cliente, String indirizzo_cliente, RecordStatusEnum recordStatusEnum) {
        this.id = id;
        this.nome_cliente = nome_cliente;
        this.cognome_cliente = cognome_cliente;
        this.genere_cliente = genere_cliente;
        this.email_cliente = email_cliente;
        this.codiceFiscale_cliente = codiceFiscale_cliente;
        this.eta_cliente = eta_cliente;
        this.indirizzo_cliente = indirizzo_cliente;
        this.recordStatusEnum = recordStatusEnum;
    }

    @NonNull
    public RecordStatusEnum getRecordStatusEnum() {
        return recordStatusEnum;
    }

    public void setRecordStatusEnum(@NonNull RecordStatusEnum recordStatusEnum) {
        this.recordStatusEnum = recordStatusEnum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getCognome_cliente() {
        return cognome_cliente;
    }

    public void setCognome_cliente(String cognome_cliente) {
        this.cognome_cliente = cognome_cliente;
    }

    public String getGenere_cliente() {
        return genere_cliente;
    }

    public void setGenere_cliente(String genere_cliente) {
        this.genere_cliente = genere_cliente;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public String getCodiceFiscale_cliente() {
        return codiceFiscale_cliente;
    }

    public void setCodiceFiscale_cliente(String codiceFiscale_cliente) {
        this.codiceFiscale_cliente = codiceFiscale_cliente;
    }

    public Integer getEta_cliente() {
        return eta_cliente;
    }

    public void setEta_cliente(Integer eta_cliente) {
        this.eta_cliente = eta_cliente;
    }

    public String getIndirizzo_cliente() {
        return indirizzo_cliente;
    }

    public void setIndirizzo_cliente(String indirizzo_cliente) {
        this.indirizzo_cliente = indirizzo_cliente;
    }
}
