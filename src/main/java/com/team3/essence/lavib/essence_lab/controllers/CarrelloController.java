package com.team3.essence.lavib.essence_lab.controllers;



import com.team3.essence.lavib.essence_lab.entities.Carrello;
import com.team3.essence.lavib.essence_lab.services.CarrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Carrello")
public class CarrelloController {
    @Autowired
    private CarrelloService carrelloService;
    /**
     *
     * @param carrello
     * @return carrello aggiunto.
     */
    @PostMapping("/add")
    public ResponseEntity<Carrello> postCarrello(@RequestBody Carrello carrello) {
        Carrello carrelloAdded = carrelloService.addCarrello(carrello);
        return ResponseEntity.ok().body(carrelloAdded);
    }

    /**
     *
     * @return  mostra la lista completa dei carrelli attivi.
     */
    @GetMapping("/viewAll")
    public ResponseEntity<List<Carrello>> getAllCarrelli() {
        List<Carrello> carrelloView = carrelloService.getCarrelli();
        return ResponseEntity.ok().body(carrelloView);
    }

    /**
     *
     * @param id con l'id cerca carrello
     * @return mostra il carrello trovato o se non esiste mostra "not found".
     */

    @GetMapping("/viewSingle/{id}")
    public ResponseEntity<Carrello> getCarrello(@PathVariable Long id) {
        Optional<Carrello> carrelloOptional = carrelloService.getCarrello(id);
        if (carrelloOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(carrelloOptional.get());
    }

    /**
     *
     * @param id con l'id cerca i carrelli
     * @param carrello
     * @return mostra i carrelli aggiornati se ci sono altrimenti mostra "not found"
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Carrello> updateCarrello(
            @PathVariable Long id,
            @RequestBody Carrello carrello) {
        Optional<Carrello> carrelloOptional = carrelloService.updateCarrello(carrello, id);
        if (carrelloOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(carrelloOptional.get());
    }

    /**
     *
     * @param id con l'id cerca i carrelli
     * @return mostra il carrello e lo disattiva se c'è altrimenti mostra "not found"
     */
    @DeleteMapping("/deactive/{id}")
    public ResponseEntity<Carrello> deleteCarrelloById(@PathVariable Long id) {
        Optional<Carrello> carrelloOptional = carrelloService.deactiveCarrelloById(id);
        if (carrelloOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(carrelloOptional.get());
    }

    /**
     *
     * @return tutti i carrelli inattivi
     */
    @GetMapping("/viewInactive")
    public ResponseEntity<List<Carrello>> findByInactive(){
        Optional<List<Carrello>> listCarrello = carrelloService.getByRecordStatusInactive();
        if (listCarrello.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(listCarrello.get());
    }

    /**
     *
     * @param id con l'id cerca i carrelli
     * @return mostra il carrello e lo attiva se c'è altrimenti mostra "not found"
     */
    @DeleteMapping("/active/{id}")
    public ResponseEntity<Carrello> activeCarrelloById(@PathVariable Long id) {
        Optional<Carrello> carrelloOptional = carrelloService.activeCarrelloById(id);
        if (carrelloOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(carrelloOptional.get());
    }
}
