package com.team3.essence.lavib.essence_lab.entities;

import com.team3.essence.lavib.essence_lab.Enum.EnumTipoCatalogo;
import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.lang.NonNull;

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
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "record_status", nullable = false, length = 1)
    private RecordStatusEnum recordStatusEnum =  RecordStatusEnum .A;
    @Enumerated(EnumType.STRING)
    private EnumTipoCatalogo enumTipoCatalogo;

    public Catalogo(){}
    public Catalogo(Long id, String nome_catalogo, Integer capienza_catalogo, List<Profumo> profumi, Negozio negozio, RecordStatusEnum recordStatusEnum, EnumTipoCatalogo enumTipoCatalogo) {
        this.id = id;
        this.nome_catalogo = nome_catalogo;
        this.capienza_catalogo = capienza_catalogo;
        this.profumi = profumi;
        this.negozio = negozio;
        this.recordStatusEnum = recordStatusEnum;
        this.enumTipoCatalogo = enumTipoCatalogo;
    }

    @NonNull
    public RecordStatusEnum getRecordStatusEnum() {
        return recordStatusEnum;
    }

    public void setRecordStatusEnum(@NonNull RecordStatusEnum recordStatusEnum) {
        this.recordStatusEnum = recordStatusEnum;
    }

    public EnumTipoCatalogo getEnumTipoCatalogo() {
        return enumTipoCatalogo;
    }

    public void setEnumTipoCatalogo(EnumTipoCatalogo enumTipoCatalogo) {
        this.enumTipoCatalogo = enumTipoCatalogo;
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
