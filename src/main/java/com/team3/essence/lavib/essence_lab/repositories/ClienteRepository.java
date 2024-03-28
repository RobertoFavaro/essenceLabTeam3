package com.team3.essence.lavib.essence_lab.repositories;

import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import com.team3.essence.lavib.essence_lab.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
//TODO in ogni classe va fatta la lettura di solo record con recordstatus ad A (custom query)
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByName(String name);
    List<Cliente> findByCognome(String cognome);
    List<Cliente> findByGenere(String genere);
    List<Cliente> findByEmail(String email);
    List<Cliente> findByCodiceFiscale(String codiceFiscale);
    List<Cliente> findByEta(Integer eta);
    List<Cliente> findByIndirizzo(String indirizzo);
    List<Cliente> findByRecordStatus(RecordStatusEnum recordStatusEnum);
}

