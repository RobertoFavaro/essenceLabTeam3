package com.team3.essence.lavib.essence_lab.controllers;

import com.team3.essence.lavib.essence_lab.entities.Negozio;
import com.team3.essence.lavib.essence_lab.entities.Profumo;
import com.team3.essence.lavib.essence_lab.services.ProfumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profumo")
public class ProfumoController {
    @Autowired
    private ProfumoService profumoService;

    /**
     * @param profumo
     * @return profumo aggiunto.
     */
    @PutMapping("/add")
    public ResponseEntity<Profumo> addProfumo(@RequestBody Profumo profumo) {
        Profumo profumoAdded = profumoService.addProfumo(profumo);
        return ResponseEntity.ok().body(profumoAdded);
    }

    /**
     * @return mostra la lista completa dei profumi.
     */
    @GetMapping("/viewProfumi")
    public ResponseEntity<List<Profumo>> getListaProfumo() {
        List<Profumo> profumoView = profumoService.getAllProfumi();
        return ResponseEntity.ok().body(profumoView);
    }

    /**
     * @param id con l'id cerca il profumo
     * @return mostra il profumo trovato o se non esiste mostra "not found".
     */
    @GetMapping("/profumo/{id}")
    public ResponseEntity<Profumo> getProfumoId(@PathVariable Long id) {
        Optional<Profumo> profumoOptional = profumoService.getProfumoId(id);
        if (profumoOptional.isPresent()) {
            return ResponseEntity.ok().body(profumoOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * @param id      con l'id cerca i negozi
     * @param profumo
     * @return mostra il profumo aggiornato se c'è altrimenti mostra "not found"
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Profumo> updateProfumo(@PathVariable Long id, @RequestBody Profumo profumo) {
        Optional<Profumo> profumoToUpdate = profumoService.updateProfumoId(id, profumo);
        if (profumoToUpdate.isPresent()) {
            return ResponseEntity.ok().body(profumoToUpdate.get());
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * @param id con l'id cerca i profumi
     * @return mostra i profumi elminati se ci sono altrimenti mostra "not found"
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Profumo> deleteProfumo(@PathVariable Long id) {
        Optional<Profumo> deleteProfumo = profumoService.deleteProfumo(id);
        if (deleteProfumo.isPresent()) {
            return ResponseEntity.ok().body(deleteProfumo.get());
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * @return lista profumi con record status attivo
     */
    @GetMapping("/active")
    public ResponseEntity<List<Profumo>> findByActive() {
        Optional<List<Profumo>> listaProfumi = profumoService.getByRecordStatusActive();
        if (listaProfumi.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(listaProfumi.get());
    }

    /**
     * @return lista profumi con record status inattivo
     */
    @GetMapping("/inactive")
    public ResponseEntity<List<Profumo>> findByInactive() {
        Optional<List<Profumo>> listaProfumi = profumoService.getByRecordStatusInactive();
        if (listaProfumi.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(listaProfumi.get());
    }
}
