package com.team3.essence.lavib.essence_lab.services;

import com.team3.essence.lavib.essence_lab.entities.Carrello;
import com.team3.essence.lavib.essence_lab.entities.Cliente;
import com.team3.essence.lavib.essence_lab.repositories.CarrelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrelloService {

    @Autowired
    private CarrelloRepository carrelloRepository;


    public Carrello addCarrello(Carrello carrello){
        return carrelloRepository.save(carrello);
    }

    public List<Carrello> getCarrelli() {
        return carrelloRepository.findAll();
    }

    public Optional<Carrello> getCarrello(Long id){
        return carrelloRepository.findById(id);
    }

    public Optional<Carrello> updateCarrello(Carrello carrello, Long id) {
        Optional<Carrello> carrelloOptional = carrelloRepository.findById(id);
        if (carrelloOptional.isPresent()) {
            carrelloOptional.get().setCliente(carrello.getCliente());
            carrelloOptional.get().setProfumi(carrello.getProfumi());
            carrelloOptional.get().setPrezzoTotale(carrello.getPrezzoTotale());
            Carrello carrelloUpdated = carrelloRepository.save((carrelloOptional.get()));
            return Optional.of(carrelloUpdated);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Carrello> deleteCarrelloById(Long id) {
        Optional<Carrello> carrelloOptional = carrelloRepository.findById(id);
        if (carrelloOptional.isPresent()) {
            carrelloRepository.delete(carrelloOptional.get());
        } else {
            return Optional.empty();
        }
        return carrelloOptional;
    }
}
