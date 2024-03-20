package com.team3.essence.lavib.essence_lab.entities;

import com.team3.essence.lavib.essence_lab.Enum.EnumTipoEssenza;
import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.lang.NonNull;

@Table
@Entity
public class Essenza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome_essenza;
    @Column(nullable = false)
    private String allergeni_essenza;
    @Column(nullable = false)
    private String descrizione_essenza;
    @Column(nullable = false)
    private Double prezzo_essenza;
    @Column(nullable = false)
    private String ingredienti_essenza;
    @ManyToOne
    @JoinColumn(name = "profumo_id")
    private Profumo profumo;
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "record_status", nullable = false, length = 1)
    private RecordStatusEnum recordStatusEnum =  RecordStatusEnum .A;
    @Enumerated(EnumType.STRING)
    private EnumTipoEssenza enumTipoEssenza;
    public Essenza(){}

    public Essenza(Long id, String nome_essenza, String allergeni_essenza, Double prezzo_essenza, String ingredienti_essenza, Profumo profumo,String descrizione_essenza, RecordStatusEnum recordStatusEnum) {
        this.id = id;
        this.nome_essenza = nome_essenza;
        this.allergeni_essenza = allergeni_essenza;
        this.prezzo_essenza = prezzo_essenza;
        this.ingredienti_essenza = ingredienti_essenza;
        this.profumo = profumo;
        this.descrizione_essenza = descrizione_essenza;
        this.recordStatusEnum = recordStatusEnum;
    }

    public EnumTipoEssenza getEnumTipoEssenza() {
        return enumTipoEssenza;
    }

    public void setEnumTipoEssenza(EnumTipoEssenza enumTipoEssenza) {
        this.enumTipoEssenza = enumTipoEssenza;
    }

    public RecordStatusEnum getRecordStatusEnum() {
        return recordStatusEnum;
    }

    public void setRecordStatusEnum(RecordStatusEnum recordStatusEnum) {
        this.recordStatusEnum = recordStatusEnum;
    }

    public String getDescrizione_essenza() {
        return descrizione_essenza;
    }

    public void setDescrizione_essenza(String descrizione_essenza) {
        this.descrizione_essenza = descrizione_essenza;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_essenza() {
        return nome_essenza;
    }

    public void setNome_essenza(String nome_essenza) {
        this.nome_essenza = nome_essenza;
    }

    public String getAllergeni_essenza() {
        return allergeni_essenza;
    }

    public void setAllergeni_essenza(String allergeni_essenza) {
        this.allergeni_essenza = allergeni_essenza;
    }

    public Double getPrezzo_essenza() {
        return prezzo_essenza;
    }

    public void setPrezzo_essenza(Double prezzo_essenza) {
        this.prezzo_essenza = prezzo_essenza;
    }

    public String getIngredienti_essenza() {
        return ingredienti_essenza;
    }

    public void setIngredienti_essenza(String ingredienti_essenza) {
        this.ingredienti_essenza = ingredienti_essenza;
    }

    public Profumo getProfumo() {
        return profumo;
    }

    public void setProfumo(Profumo profumo) {
        this.profumo = profumo;
    }
}
