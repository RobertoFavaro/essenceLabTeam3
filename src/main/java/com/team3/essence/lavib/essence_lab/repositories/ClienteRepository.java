package com.team3.essence.lavib.essence_lab.repositories;

import com.team3.essence.lavib.essence_lab.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.nio.file.LinkOption;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
