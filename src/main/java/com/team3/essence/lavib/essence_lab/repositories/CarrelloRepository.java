package com.team3.essence.lavib.essence_lab.repositories;

import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import com.team3.essence.lavib.essence_lab.entities.Carrello;
import com.team3.essence.lavib.essence_lab.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarrelloRepository extends JpaRepository<Carrello,Long> {
    List<Carrello> findByRecordStatus(RecordStatusEnum recordStatusEnum);
}
