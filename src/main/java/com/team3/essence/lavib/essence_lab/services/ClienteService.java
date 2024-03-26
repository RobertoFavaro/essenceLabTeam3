package com.team3.essence.lavib.essence_lab.services;


import com.team3.essence.lavib.essence_lab.entities.Cliente;

import com.team3.essence.lavib.essence_lab.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    /**
     *
     * @param clienteToAdd
     * @return Salva l'oggetto e lo ritorna;
     */
    public Cliente addCliente(Cliente clienteToAdd) {
        return clienteRepository.save(clienteToAdd);
    }

    /**
     *
     * @return mostra la lista di tutti i cliente;
     */

    public List<Cliente> getCliente() {
        return clienteRepository.findAll();
    }

    /**
     *
     * @param id
     * @return mostra i cliente cercata tramite id;
     */
    public Optional<Cliente> getCliente(Long id) {
        return clienteRepository.findById(id);
    }

    /**
     *
     * @param cliente per cercare il cliente da aggiornare
     * @param id
     * @return mostra il cliente aggiornata o un oggetto vuoto se non è presente
     */

    public Optional<Cliente> updateCliente(Cliente cliente, Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            clienteOptional.get().setNome_cliente(cliente.getNome_cliente());
            clienteOptional.get().setCognome_cliente(cliente.getCognome_cliente());
            clienteOptional.get().setEmail_cliente(cliente.getEmail_cliente());
            clienteOptional.get().setCodiceFiscale_cliente(cliente.getCodiceFiscale_cliente());
            clienteOptional.get().setRecordStatusEnum(cliente.getRecordStatusEnum());
            clienteOptional.get().setId(cliente.getId());
            clienteOptional.get().setEta_cliente(cliente.getEta_cliente());
            clienteOptional.get().setGenere_cliente(cliente.getGenere_cliente());
            Cliente clienteUpdated = clienteRepository.save(clienteOptional.get());
            return Optional.of(clienteUpdated);
        } else {
            return Optional.empty();
        }
    }

    /**
     *
     * @param id per cercare il cliente da eliminare
     * @return mostra il cliente eliminata o un oggetto vuoto se non esiste
     */

    public Optional<Cliente> deleteClienteById(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            clienteRepository.delete(clienteOptional.get());
        } else {
            return Optional.empty();
        }
        return clienteOptional;
    }
}