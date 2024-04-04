package com.team3.essence.lavib.essence_lab.controllers;



import com.team3.essence.lavib.essence_lab.entities.Cliente;
import com.team3.essence.lavib.essence_lab.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    /**
     *
     * @param clienteToAdd
     * @return cliente aggiunto.
     */
    @PostMapping("/add")
    public ResponseEntity<Cliente> postCliente(@RequestBody Cliente clienteToAdd) {
        Cliente clienteAdded = clienteService.addCliente(clienteToAdd);
        return ResponseEntity.ok().body(clienteAdded);
    }

    /**
     *
     * @return  mostra la lista completa dei clienti attivi.
     */
    @GetMapping("/viewAll")
    public ResponseEntity<List<Cliente>> getAllClienti() {
        List<Cliente> clienteView = clienteService.getAllCliente();
        return ResponseEntity.ok().body(clienteView);
    }

    /**
     *
     * @param id con l'id cerca cliente
     * @return mostra il cliente trovato o se non esiste mostra "not found".
     */

    @GetMapping("/viewSingle/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteService.getCliente(id);
        if (clienteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(clienteOptional.get());
    }

    /**
     *
     * @param id con l'id cerca i clienti
     * @param cliente
     * @return mostra i clienti aggiornati se ci sono altrimenti mostra "not found"
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Cliente> updateCliente(
            @PathVariable Long id,
            @RequestBody Cliente cliente) {
        Optional<Cliente> clienteOptional = clienteService.updateCliente(cliente, id);
        if (clienteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(clienteOptional.get());
    }

    /**
     *
     * @param id con l'id cerca i clienti
     * @return mostra il cliente e lo disattiva se c'è altrimenti mostra "not found"
     */
    @DeleteMapping("/deactive/{id}")
    public ResponseEntity<Cliente> deleteClienteById(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteService.deactiveClienteById(id);
        if (clienteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(clienteOptional.get());
    }

    /**
     *
     * @return tutti i clienti inattivi
     */
    @GetMapping("/viewInactive")
    public ResponseEntity<List<Cliente>> findByInactive(){
        Optional<List<Cliente>> listClient = clienteService.getByRecordStatusInactive();
        if (listClient.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(listClient.get());
    }

    /**
     *
     * @param id con l'id cerca i clienti
     * @return mostra il cliente e lo attiva se c'è altrimenti mostra "not found"
     */
    @DeleteMapping("/active/{id}")
    public ResponseEntity<Cliente> activeClienteById(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteService.activeClienteById(id);
        if (clienteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(clienteOptional.get());
    }
}