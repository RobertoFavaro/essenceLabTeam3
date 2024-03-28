package com.team3.essence.lavib.essence_lab.repositories;

import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import com.team3.essence.lavib.essence_lab.entities.Essenza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EssenzaRepository extends JpaRepository<Essenza, Long> {
    List<Essenza> findByNome(String nome);
    List<Essenza> findByAllergeni(String allergeni);
    List<Essenza> findByDescrizione(String descrizione);
    List<Essenza> findByPrezzo(Double prezzo);
    List<Essenza> findByIngredienti(String ingredienti);
    List<Essenza> findByProfumo(String profumo);
    List<Essenza> findByRecordStatus(RecordStatusEnum recordStatusEnum);

}
