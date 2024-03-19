package com.team3.essence.lavib.essence_lab.repositories;

import com.team3.essence.lavib.essence_lab.entities.Negozio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NegozioRepository extends JpaRepository<Negozio, Long> {
}
