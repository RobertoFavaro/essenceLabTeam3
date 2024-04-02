package com.team3.essence.lavib.essence_lab.controllers;

import com.team3.essence.lavib.essence_lab.entities.Carrello;
import com.team3.essence.lavib.essence_lab.entities.Cliente;
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

    @PostMapping("/addCarrello")
    public ResponseEntity<Carrello> addCarrello(@RequestBody Carrello carrello) {
        Carrello carrelloToAdd = carrelloService.addCarrello(carrello);
        return ResponseEntity.ok().body(carrelloToAdd);
    }

    @GetMapping("/getAllCarrelli")
    public ResponseEntity<List<Carrello>> getCarrelli() {
        List<Carrello> carrelloView = carrelloService.getCarrelli();
        return ResponseEntity.ok().body(carrelloView);
    }

    @GetMapping("/getSingleCarrello/{id}")
    public ResponseEntity<Carrello> getCarrello(@PathVariable Long id) {
        Optional<Carrello> carrelloOptional = carrelloService.getCarrello(id);
        if (carrelloOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(carrelloOptional.get());
    }

    @PutMapping("/updateCarrello/{id}")
    public ResponseEntity<Carrello> updateCarrello(
            @PathVariable Long id,
            @RequestBody Carrello carrello) {
        Optional<Carrello> carrelloOptional = carrelloService.updateCarrello(carrello, id);
        if (carrelloOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(carrelloOptional.get());
    }
    @DeleteMapping("/deleteCarrello/{id}")
    public ResponseEntity<Carrello> deleteCarrelloById(@PathVariable Long id) {
        Optional<Carrello> carrelloOptional = carrelloService.deleteCarrelloById(id);
        if (carrelloOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(carrelloOptional.get());
    }
}
