package com.team3.essence.lavib.essence_lab.entities;

import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

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
    @OneToMany(mappedBy = "negozio")
    private List<Catalogo> cataloghi;
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "record_status", nullable = false, length = 1)
    private RecordStatusEnum recordStatusEnum =  RecordStatusEnum .A;

    public Negozio(){}
    public Negozio(Long id, String nome_negozio, String luogo_negozio, String indirizzo_negozio, String partita_iva_negozio, List<Catalogo> lista_di_cataloghi, RecordStatusEnum recordStatusEnum) {
        this.id = id;
        this.nome_negozio = nome_negozio;
        this.luogo_negozio = luogo_negozio;
        this.indirizzo_negozio = indirizzo_negozio;
        this.partita_iva_negozio = partita_iva_negozio;
        this.cataloghi = lista_di_cataloghi;
        this.recordStatusEnum = recordStatusEnum;
    }

    public RecordStatusEnum getRecordStatusEnum() {
        return recordStatusEnum;
    }

    public void setRecordStatusEnum(RecordStatusEnum recordStatusEnum) {
        this.recordStatusEnum = recordStatusEnum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_negozio() {
        return nome_negozio;
    }

    public void setNome_negozio(String nome_negozio) {
        this.nome_negozio = nome_negozio;
    }

    public String getLuogo_negozio() {
        return luogo_negozio;
    }

    public void setLuogo_negozio(String luogo_negozio) {
        this.luogo_negozio = luogo_negozio;
    }

    public String getIndirizzo_negozio() {
        return indirizzo_negozio;
    }

    public void setIndirizzo_negozio(String indirizzo_negozio) {
        this.indirizzo_negozio = indirizzo_negozio;
    }

    public String getPartita_iva_negozio() {
        return partita_iva_negozio;
    }

    public void setPartita_iva_negozio(String partita_iva_negozio) {
        this.partita_iva_negozio = partita_iva_negozio;
    }

    public List<Catalogo> getLista_di_cataloghi() {
        return cataloghi;
    }

    public void setLista_di_cataloghi(List<Catalogo> lista_di_cataloghi) {
        this.cataloghi = lista_di_cataloghi;
    }

    public List<Catalogo> getCataloghi() {
        return cataloghi;
    }

    public void setCataloghi(List<Catalogo> cataloghi) {
        this.cataloghi = cataloghi;
    }
}
