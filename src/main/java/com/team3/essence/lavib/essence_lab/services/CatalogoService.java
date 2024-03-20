package com.team3.essence.lavib.essence_lab.services;

import com.team3.essence.lavib.essence_lab.entities.Catalogo;
import com.team3.essence.lavib.essence_lab.repositories.CatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogoService {
    @Autowired
    private CatalogoRepository catalogoRepository;

    public Catalogo addCatalog(Catalogo catalogToAdd) {
        return catalogoRepository.save(catalogToAdd);
    }

    public List<Catalogo> getCatalogs() {
        return catalogoRepository.findAll();
    }

    public Optional<Catalogo> getCatalog(Long id) {
        return catalogoRepository.findById(id);
    }

    public Optional<Catalogo> updateCatalog(Catalogo catalog, Long id) {
        Optional<Catalogo> catalogOptional = catalogoRepository.findById(id);
        if (catalogOptional.isPresent()) {
            catalogOptional.get().setNome_catalogo(catalog.getNome_catalogo());
            catalogOptional.get().setCapienza_catalogo(catalog.getCapienza_catalogo());
            catalogOptional.get().setProfumi(catalog.getProfumi());
            catalogOptional.get().setNegozio(catalog.getNegozio());
            catalogOptional.get().setRecordStatusEnum(catalog.getRecordStatusEnum());
            catalogOptional.get().setEnumTipoCatalogo(catalog.getEnumTipoCatalogo());
            Catalogo catalogUpdated = catalogoRepository.save(catalogOptional.get());
            return Optional.of(catalogUpdated);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Catalogo> deleteCatalogById(Long id) {
        Optional<Catalogo> catalogOptional = catalogoRepository.findById(id);
        if (catalogOptional.isPresent()) {
            catalogoRepository.delete(catalogOptional.get());
        } else {
            return Optional.empty();
        }
        return catalogOptional;
    }
}