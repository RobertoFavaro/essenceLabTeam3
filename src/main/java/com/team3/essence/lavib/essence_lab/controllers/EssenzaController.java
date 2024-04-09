package com.team3.essence.lavib.essence_lab.controllers;

import com.team3.essence.lavib.essence_lab.entities.Essenza;
import com.team3.essence.lavib.essence_lab.services.EssenzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/essenza")
public class EssenzaController {
    @Autowired
    private EssenzaService essenzaService;

    /**
     *
     * @param essenza
     * @return L'essenza aggiunta
     */
    @PutMapping("/add")
    public ResponseEntity<Essenza> addEssenza(@RequestBody Essenza essenza){
        Essenza essenzaAdded = essenzaService.addEssenza(essenza);
       return ResponseEntity.ok().body(essenzaAdded);
    }

    /**
     *
     * @return Lista completa delle essenze
     */
    @GetMapping("/viewAll")
    public ResponseEntity<List<Essenza>> getListaEssenza(){
        List<Essenza> essenzaView = essenzaService.getAllEssenze();
        return ResponseEntity.ok().body(essenzaView);
    }

    /**
     *
     * @param id per cercare l'essenza
     * @return L'essenza trovata o un not found se non esiste
     */
    @GetMapping("/viewSingle/{id}")
    public ResponseEntity<Essenza> getEssenzaId(@PathVariable Long id){
        Optional<Essenza> essenzaOptional = essenzaService.getEssenzaId(id);
        if(essenzaOptional.isPresent()){
            return ResponseEntity.ok().body(essenzaOptional.get());
        }
      return ResponseEntity.notFound().build();
    }

    /**
     *
     * @param id per cercare l 'essenza
     * @param essenza
     * @return l'essenza aggiornata se è esistente altrimenti ritorna un not found;
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Essenza> updateEssenza(@PathVariable Long id,@RequestBody Essenza essenza){
        Optional<Essenza> essenzaUpdate = essenzaService.updateEssenzaId(id,essenza);
        if(essenzaUpdate.isPresent()){
            return ResponseEntity.ok().body(essenzaUpdate.get());
        }
        return ResponseEntity.notFound().build();
    }

    /**
     *
     * @param id con l'id cerca le essenze
     * @return mostra l'essenza e lo disattiva se c'è altrimenti mostra "not found"
     */
    @DeleteMapping("/deactive/{id}")
    public ResponseEntity<Essenza> deleteClienteById(@PathVariable Long id) {
        Optional<Essenza> essenzaOptional = essenzaService.deactiveEssenzaById(id);
        if (essenzaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(essenzaOptional.get());
    }

    /**
     *
     * @return tutte le essenze inattive
     */
    @GetMapping("/viewInactive")
    public ResponseEntity<List<Essenza>> findByInactive(){
        Optional<List<Essenza>> listEssenze = essenzaService.getByRecordStatusInactive();
        if (listEssenze.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(listEssenze.get());
    }

    /**
     *
     * @param id con l'id cerca le essenze
     * @return mostra l' essenza e la attiva se c'è altrimenti mostra "not found"
     */
    @DeleteMapping("/active/{id}")
    public ResponseEntity<Essenza> activeEssenzaById(@PathVariable Long id) {
        Optional<Essenza> essenzaOptional = essenzaService.activeEssenzaById(id);
        if (essenzaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(essenzaOptional.get());
    }
}
