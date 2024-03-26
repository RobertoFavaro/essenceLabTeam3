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

    /**
     *
     * @param catalogToAdd
     * @return catalogo aggiunto.
     */
    @PostMapping("/addCatalog")
    public ResponseEntity<Catalogo> postEvento(@RequestBody Catalogo catalogToAdd) {
        Catalogo catalogoAdded = catalogoService.addCatalog(catalogToAdd);
        return ResponseEntity.ok().body(catalogoAdded);
    }

    /**
     *
     * @return  mostra la lista completa dei cataloghi.
     */
    @GetMapping("/getAllCatalogs")
    public ResponseEntity<List<Catalogo>> getCatalogs() {
        List<Catalogo> catalogoView = catalogoService.getCatalogs();
        return ResponseEntity.ok().body(catalogoView);
    }

    /**
     *
     * @param id con l'id cerca catalogo
     * @return mostra il catalogo trovato o se non esiste mostra "not found".
     */

    @GetMapping("/getSingleCatalog/{id}")
    public ResponseEntity<Catalogo> getCatalog(@PathVariable Long id) {
        Optional<Catalogo> catalogOptional = catalogoService.getCatalog(id);
        if (catalogOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(catalogOptional.get());
    }

    /**
     *
     * @param id con l'id cerca i cataloghi
     * @param catalog
     * @return mostra i cataloghi aggiornati se ci sono altrimenti mostra "not found"
     */
    @PutMapping("/updateCatalog/{id}")
    public ResponseEntity<Catalogo> updateCatalog(
            @PathVariable Long id,
            @RequestBody Catalogo catalog) {
        Optional<Catalogo> catalogOptional = catalogoService.updateCatalog(catalog, id);
        if (catalogOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(catalogOptional.get());
    }

    /**
     *
     * @param id con l'id cerca i cataloghi
     * @return mostra i cataloghi elminati se ci sono altrimenti mostra "not found"
     */
    @DeleteMapping("/deleteCatalog/{id}")
    public ResponseEntity<Catalogo> deleteCatalogoById(@PathVariable Long id) {
        Optional<Catalogo> catalogOptional = catalogoService.deleteCatalogById(id);
        if (catalogOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(catalogOptional.get());
    }
}