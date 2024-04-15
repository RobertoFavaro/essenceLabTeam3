package com.team3.essence.lavib.essence_lab.entities;

import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;


import java.util.List;

@Table
@Entity
public class Negozio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String luogo;
    @Column(nullable = false)
    private String indirizzo;
    @Column(nullable = false, unique = true)
    private String partita_iva;
    @OneToMany(mappedBy = "negozio")
    private List<Profumo> profumi;
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "record_status", nullable = false, length = 1)
    private RecordStatusEnum recordStatusEnum =  RecordStatusEnum .A;

    public Negozio(){}

    public Negozio(Long id, String nome_negozio, String luogo_negozio, String indirizzo_negozio, String partita_iva_negozio, List<Profumo> profumi, RecordStatusEnum recordStatusEnum) {
        this.id = id;
        this.nome = nome_negozio;
        this.luogo = luogo_negozio;
        this.indirizzo = indirizzo_negozio;
        this.partita_iva = partita_iva_negozio;
        this.profumi = profumi;
        this.recordStatusEnum = recordStatusEnum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getPartita_iva() {
        return partita_iva;
    }

    public void setPartita_iva(String partita_iva) {
        this.partita_iva = partita_iva;
    }

    public List<Profumo> getProfumi() {
        return profumi;
    }

    public void setProfumi(List<Profumo> profumi) {
        this.profumi = profumi;
    }

    public RecordStatusEnum getRecordStatusEnum() {
        return recordStatusEnum;
    }

    public void setRecordStatusEnum(RecordStatusEnum recordStatusEnum) {
        this.recordStatusEnum = recordStatusEnum;
    }
}
