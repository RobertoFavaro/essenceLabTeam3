package com.team3.essence.lavib.essence_lab.repositories;

import com.team3.essence.lavib.essence_lab.entities.Essenza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EssenzaRepository extends JpaRepository<Essenza, Long> {
}
