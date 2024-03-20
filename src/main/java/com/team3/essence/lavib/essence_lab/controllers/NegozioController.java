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
    @PutMapping("/add")
    public ResponseEntity<Negozio> addNegozio(@RequestBody Negozio negozio){
        return ResponseEntity.ok().body(negozioService.addNegozio(negozio));
    }

    /**
     * @return mostra la lista completa dei negozi.
     */
    @GetMapping ("/getlistnegozio")
    public ResponseEntity<List<Negozio>> getListaNegozio (){
        return ResponseEntity.ok().body(negozioService.getAllNegozio());
    }

    /**
     * @param id con l'id cerca negozio
     * @return mostra il negozio trovato o se non esiste mostra "not found".
     */
    @GetMapping ("/getnegozioid/{id}")
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
    @PutMapping ("/updateNegozioId/{id}")
    public ResponseEntity<Negozio> updateNegozio (@PathVariable Long id, @RequestBody Negozio negozio){
        Optional <Negozio> negozioToUpdate = negozioService.updateNegozio(id, negozio);
        if (negozioToUpdate.isPresent()){
            return ResponseEntity.ok().body(negozioToUpdate.get());
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * @param id con l'id cerca i negozi
     * @return mostra i negozi elminati se ci sono altrimenti mostra "not found"
     */
    @DeleteMapping ("/deletenegozio/{id}")
    public ResponseEntity<Negozio> deleteNegozio (@PathVariable Long id){
        Optional <Negozio> deleteNegozio = negozioService.deleteNegozio(id);
        if (deleteNegozio.isPresent()){
            return ResponseEntity.ok().body(deleteNegozio.get());
        }
        return ResponseEntity.notFound().build();
    }
}