package com.team3.essence.lavib.essence_lab.repositories;

import com.team3.essence.lavib.essence_lab.Enum.EnumCategoriaProfumo;
import com.team3.essence.lavib.essence_lab.Enum.EnumMarcaProfumo;
import com.team3.essence.lavib.essence_lab.Enum.EnumTipoProfumo;
import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import com.team3.essence.lavib.essence_lab.entities.Profumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfumoRepository extends JpaRepository<Profumo, Long> {
    List<Profumo> findByNome(String nome_profumo);

    List<Profumo> findByDesc(String descrizione_profumo);

    List<Profumo> findByIngredienti(String ingredienti_profumo);

    List<Profumo> findByprezzo(Double prezzo_profumo);

    List<Profumo> findByAllergeni(String allergeni_profumo);

    List<Profumo> findByRecordStatus(RecordStatusEnum recordStatusEnum);

    List<Profumo> findByRecordStatus(EnumTipoProfumo enumTipoProfumo);

    List<Profumo> findByRecordStatus(EnumMarcaProfumo enumMarcaProfumo);

    List<Profumo> findByRecordStatus(EnumCategoriaProfumo enumCategoriaProfumo);


}
