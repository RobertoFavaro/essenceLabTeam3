package com.team3.essence.lavib.essence_lab.services;


import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import com.team3.essence.lavib.essence_lab.entities.Carrello;
import com.team3.essence.lavib.essence_lab.repositories.CarrelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrelloService {
    @Autowired
    private CarrelloRepository carrelloRepository;

    /**
     *
     * @param carrello
     * @return Salva l'oggetto e lo ritorna;
     */
    public Carrello addCarrello(Carrello carrello){
        return carrelloRepository.save(carrello);
    }
    /**
     *
     * @return mostra la lista di tutti i carrelli;
     */
    public List<Carrello> getCarrelli() {
        return carrelloRepository.findAllActiveCarrelli();
    }
    /**
     *
     * @param id
     * @return mostra i carrelli cercata tramite id;
     */
    public Optional<Carrello> getCarrello(Long id){
        return carrelloRepository.findById(id);
    }
    /**
     *
     * @param carrello per cercare il carrello da aggiornare
     * @param id
     * @return mostra il carrello aggiornata o un oggetto vuoto se non è presente
     */
    public Optional<Carrello> updateCarrello(Carrello carrello, Long id) {
        Optional<Carrello> carrelloOptional = carrelloRepository.findById(id);
        if (carrelloOptional.isPresent()) {
            carrelloOptional.get().setClienti(carrello.getClienti());
            carrelloOptional.get().setProfumi(carrello.getProfumi());
            carrelloOptional.get().setPrezzoTotale(carrello.getPrezzoTotale());
            Carrello carrelloUpdated = carrelloRepository.save((carrelloOptional.get()));
            return Optional.of(carrelloUpdated);
        } else {
            return Optional.empty();
        }
    }
    /**
     *
     * @param id
     * @return il recordStatusEnum diventa inattivo
     */
    public Optional<Carrello> deactiveCarrelloById(Long id) {
        Optional<Carrello> carrelloOptional = carrelloRepository.findById(id);
        if (carrelloOptional.isPresent()) {
            carrelloOptional.get().setRecordStatusEnum(RecordStatusEnum.I);
        } else {
            return Optional.empty();
        }
        return carrelloOptional;
    }
    /**
     *
     * @param id
     * @return il recordStatusEnum diventa attivo
     */
    public Optional<Carrello> activeCarrelloById(Long id) {
        Optional<Carrello> carrelloOptional = carrelloRepository.findById(id);
        if (carrelloOptional.isPresent()) {
            carrelloOptional.get().setRecordStatusEnum(RecordStatusEnum.A);
        } else {
            return Optional.empty();
        }
        return carrelloOptional;
    }

    /**
     *
     * @return tutti i carrelli inattivi
     */
    public Optional<List<Carrello>> getByRecordStatusInactive(){
        Optional<List<Carrello>> listCarrello = Optional.ofNullable(carrelloRepository.findByRecordStatusEnum(RecordStatusEnum.I));
        return listCarrello;
    }
}
