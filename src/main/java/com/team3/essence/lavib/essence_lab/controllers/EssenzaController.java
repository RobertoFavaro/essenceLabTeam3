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
       return ResponseEntity.ok().body(essenzaService.addEssenza(essenza));
    }

    /**
     *
     * @return Lista completa delle essenze
     */
    @GetMapping("/getListaEssenza")
    public ResponseEntity<List<Essenza>> getListaEssenza(){
        return ResponseEntity.ok().body(essenzaService.getAllEssenze());
    }

    /**
     *
     * @param id per cercare l'essenza
     * @return L'essenza trovata o un not found se non esiste
     */
    @GetMapping("/getEssenzaId/{id}")
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
    @PutMapping("/updateEssenzaId/{id}")
    public ResponseEntity<Essenza> updateEssenza(@PathVariable Long id,@RequestBody Essenza essenza){
        Optional<Essenza> essenzaUpdate = essenzaService.updateEssenzaId(id,essenza);
        if(essenzaUpdate.isPresent()){
            return ResponseEntity.ok().body(essenzaUpdate.get());
        }
        return ResponseEntity.notFound().build();
    }

    /**
     *
     * @param id per cercare l'essenza
     * @return L'essenza eliminata altrimenti se non presente ritorno un not found
     */
    @DeleteMapping("/deleteEssenza/{id}")
    public ResponseEntity<Essenza> deleteEssenza(@PathVariable Long id){
        Optional<Essenza> deleteEssenza = essenzaService.deleteEssenza(id);
        if(deleteEssenza.isPresent()){
            return ResponseEntity.ok().body(deleteEssenza.get());
        }
        return ResponseEntity.notFound().build();
    }
}
