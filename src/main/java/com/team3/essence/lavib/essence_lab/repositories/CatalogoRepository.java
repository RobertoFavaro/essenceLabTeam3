package com.team3.essence.lavib.essence_lab.repositories;

import com.team3.essence.lavib.essence_lab.entities.Catalogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.nio.file.LinkOption;
@Repository
public interface CatalogoRepository extends JpaRepository<Catalogo, Long> {
}
