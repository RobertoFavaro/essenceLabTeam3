package com.team3.essence.lavib.essence_lab.controllers;

import com.team3.essence.lavib.essence_lab.entities.Catalogo;
import com.team3.essence.lavib.essence_lab.services.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/catalogo")
public class CatalogoController {
    @Autowired
    private CatalogoService catalogoService;

    @PostMapping("/addCatalog")
    public ResponseEntity<Catalogo> postEvento(@RequestBody Catalogo catalogToAdd) {
        return ResponseEntity.ok().body(catalogoService.addCatalog(catalogToAdd));
    }

    @GetMapping("/getAllCatalogs")
    public ResponseEntity<List<Catalogo>> getCatalogs() {
        return ResponseEntity.ok().body(catalogoService.getCatalogs());
    }

    @GetMapping("/getSingleCatalog/{id}")
    public ResponseEntity<Catalogo> getCatalog(@PathVariable Long id) {
        Optional<Catalogo> catalogOptional = catalogoService.getCatalog(id);
        if (catalogOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(catalogOptional.get());
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Catalogo> updateCatalog(
            @PathVariable Long id,
            @RequestBody Catalogo catalog) {
        Optional<Catalogo> catalogOptional = catalogoService.updateCatalog(catalog, id);
        if (catalogOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(catalogOptional.get());
    }

    @DeleteMapping("/deleteCatalog/{id}")
    public ResponseEntity<Catalogo> deleteEventoById(@PathVariable Long id) {
        Optional<Catalogo> catalogOptional = catalogoService.deleteCatalogById(id);
        if (catalogOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(catalogOptional.get());
    }
}