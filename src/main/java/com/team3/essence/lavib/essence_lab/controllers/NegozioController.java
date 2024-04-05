package com.team3.essence.lavib.essence_lab.controllers;

import com.team3.essence.lavib.essence_lab.entities.Negozio;
import com.team3.essence.lavib.essence_lab.services.NegozioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/negozio")
public class NegozioController {
    @Autowired
    private NegozioService negozioService;

    /**
     * @param negozio
     * @return negozio aggiunto.
     */
    @PostMapping("/add")
    public ResponseEntity<Negozio> addNegozio(@RequestBody Negozio negozio){
        Negozio negozioAdded = negozioService.addNegozio(negozio);
        return ResponseEntity.ok().body(negozioAdded);
    }

    /**
     * @return mostra la lista completa dei negozi.
     */
    @GetMapping ("/viewAll")
    public ResponseEntity<List<Negozio>> getAllNegozio (){
        List<Negozio> negozioView = negozioService.getAllNegozio();
        return ResponseEntity.ok().body(negozioView);
    }

    /**
     * @param id con l'id cerca negozio
     * @return mostra il negozio trovato o se non esiste mostra "not found".
     */
    @GetMapping ("/viewSingle/{id}")
    public ResponseEntity<Negozio> getNegozioId (@PathVariable Long id){
        Optional<Negozio> negozioOptional = negozioService.getNegozioId(id);
        if (negozioOptional.isPresent()){
            return ResponseEntity.ok().body(negozioOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * @param id con l'id cerca i negozi
     * @param negozio
     * @return mostra i negozi aggiornati se ci sono altrimenti mostra "not found"
     */
    @PutMapping ("/update/{id}")
    public ResponseEntity<Negozio> updateNegozio (@PathVariable Long id, @RequestBody Negozio negozio){
        Optional <Negozio> negozioToUpdate = negozioService.updateNegozio(id, negozio);
        if (negozioToUpdate.isPresent()){
            return ResponseEntity.ok().body(negozioToUpdate.get());
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * @param id con l'id cerca i clienti
     * @return mostra il cliente e lo disattiva se c'è altrimenti mostra "not found"
     */
    @DeleteMapping ("/deactive/{id}")
    public ResponseEntity<Negozio> deleteNegozio (@PathVariable Long id){
        Optional <Negozio> deleteNegozio = negozioService.deactivateNegozioById(id);
        if (deleteNegozio.isPresent()){
            return ResponseEntity.ok().body(deleteNegozio.get());
        }
        return ResponseEntity.notFound().build();
    }

    /**
     *
     * @param id con l'id cerca i clienti
     * @return mostra il cliente e lo attiva se c'è altrimenti mostra "not found"
     */
    @GetMapping ("/active{id}")
    public ResponseEntity<Negozio> activeNegozioById (@PathVariable Long id){
        Optional<Negozio> listNegozi = negozioService.activeNegozioById(id);
        if (listNegozi.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(listNegozi.get());
    }
    /**
     *
     * @return tutti i clienti inattivi
     */
    @GetMapping ("/viewInactive")
    public ResponseEntity<List<Negozio>> findByInactive (){
        Optional<List<Negozio>> listNegozi = negozioService.getByRecordStatusInactive();
        if (listNegozi.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(listNegozi.get());
    }
}