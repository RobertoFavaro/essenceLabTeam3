package com.team3.essence.lavib.essence_lab.repositories;

import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import com.team3.essence.lavib.essence_lab.entities.Negozio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NegozioRepository extends JpaRepository<Negozio, Long> {
    List<Negozio> findByNome_negozio(String nome_negozio);
    List<Negozio> findByLuogo_negozio(String luogo_negozio);
    List<Negozio> findByIndirizzo_negozio(String indirizzo_negozio);
    List<Negozio> findByPartita_iva_negozio(String partita_iva_negozio);
    List<Negozio> findByProfumi(String profumi);
    List<Negozio> findByRecordStatus(RecordStatusEnum recordStatus);
}
