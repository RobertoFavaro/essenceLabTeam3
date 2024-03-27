package com.team3.essence.lavib.essence_lab.entities;

import com.team3.essence.lavib.essence_lab.Enum.EnumCategoriaProfumo;
import com.team3.essence.lavib.essence_lab.Enum.EnumMarcaProfumo;
import com.team3.essence.lavib.essence_lab.Enum.EnumTipoProfumo;
import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
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
    private String descrizione_profumo;
    @Column(nullable = false)
    private String ingredienti_profumo;
    @Column(nullable = false)
    private Double prezzo_profumo;
    @Column(nullable = false)
    private String allergeni_profumo;
    @OneToMany(mappedBy = "profumo")
    private List<Essenza> essenze;
    @ManyToOne
    @JoinColumn(name = "negozio_id")
    private Negozio negozio;
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "record_status", nullable = false, length = 1)
    private RecordStatusEnum recordStatusEnum =  RecordStatusEnum .A;
    @Enumerated(EnumType.STRING)
    private EnumTipoProfumo enumTipoProfumo;
    @Enumerated(EnumType.STRING)
    private EnumMarcaProfumo enumMarcaProfumo;
    @Enumerated(EnumType.STRING)
    private EnumCategoriaProfumo enumCategoriaProfumo;

    public Profumo(){}

    public Profumo(Long id, String nome_profumo, String descrizione_profumo, String ingredienti_profumo, Double prezzo_profumo, String allergeni_profumo, RecordStatusEnum recordStatusEnum, EnumTipoProfumo enumTipoProfumo, EnumMarcaProfumo enumMarcaProfumo) {
        this.id = id;
        this.nome_profumo = nome_profumo;
        this.descrizione_profumo = descrizione_profumo;
        this.ingredienti_profumo = ingredienti_profumo;
        this.prezzo_profumo = prezzo_profumo;
        this.allergeni_profumo = allergeni_profumo;
        this.essenze = new ArrayList<>();
        this.recordStatusEnum = recordStatusEnum;
        this.enumTipoProfumo = enumTipoProfumo;
        this.enumMarcaProfumo = enumMarcaProfumo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_profumo() {
        return nome_profumo;
    }

    public void setNome_profumo(String nome_profumo) {
        this.nome_profumo = nome_profumo;
    }

    public String getDescrizione_profumo() {
        return descrizione_profumo;
    }

    public void setDescrizione_profumo(String descrizione_profumo) {
        this.descrizione_profumo = descrizione_profumo;
    }

    public String getIngredienti_profumo() {
        return ingredienti_profumo;
    }

    public void setIngredienti_profumo(String ingredienti_profumo) {
        this.ingredienti_profumo = ingredienti_profumo;
    }

    public Double getPrezzo_profumo() {
        return prezzo_profumo;
    }

    public void setPrezzo_profumo(Double prezzo_profumo) {
        this.prezzo_profumo = prezzo_profumo;
    }

    public String getAllergeni_profumo() {
        return allergeni_profumo;
    }

    public void setAllergeni_profumo(String allergeni_profumo) {
        this.allergeni_profumo = allergeni_profumo;
    }

    public List<Essenza> getEssenze() {
        return essenze;
    }

    public void setEssenze(List<Essenza> essenze) {
        this.essenze = essenze;
    }

    public RecordStatusEnum getRecordStatusEnum() {
        return recordStatusEnum;
    }

    public void setRecordStatusEnum(RecordStatusEnum recordStatusEnum) {
        this.recordStatusEnum = recordStatusEnum;
    }

    public EnumTipoProfumo getEnumTipoProfumo() {
        return enumTipoProfumo;
    }

    public void setEnumTipoProfumo(EnumTipoProfumo enumTipoProfumo) {
        this.enumTipoProfumo = enumTipoProfumo;
    }

    public EnumMarcaProfumo getEnumMarcaProfumo() {
        return enumMarcaProfumo;
    }

    public void setEnumMarcaProfumo(EnumMarcaProfumo enumMarcaProfumo) {
        this.enumMarcaProfumo = enumMarcaProfumo;
    }
}
