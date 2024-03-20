package com.team3.essence.lavib.essence_lab.services;

import com.team3.essence.lavib.essence_lab.entities.Negozio;
import com.team3.essence.lavib.essence_lab.repositories.NegozioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NegozioService {
    @Autowired
    private NegozioRepository negozioRepository;
    /**
     *
     * @param negozio
     * @return Salva l'oggetto e lo ritorna;
     */
    public Negozio addNegozio (Negozio negozio){
        return negozioRepository.save(negozio);
    }
    /**
     *
     * @return mostra la lista di tutti i negozi;
     */
    public List<Negozio> getAllNegozio(){
        return negozioRepository.findAll();
    }
    /**
     *
     * @param id
     * @return mostra i negozi cercata tramite id;
     */
    public Optional<Negozio> getNegozioId (Long id){
        return negozioRepository.findById(id);
    }
    /**
     *
     * @param id per cercare il negozio da aggiornare
     * @param negozio
     * @return mostra il negozio aggiornata o un oggetto vuoto se non è presente
     */
    public Optional<Negozio> updateNegozio (Long id, Negozio negozio){
        Optional<Negozio> updateNegozio = negozioRepository.findById(id);
        if (updateNegozio.isPresent()){
            updateNegozio.get().setIndirizzo_negozio(negozio.getIndirizzo_negozio());
            updateNegozio.get().setNome_negozio(negozio.getNome_negozio());
            updateNegozio.get().setLuogo_negozio(negozio.getLuogo_negozio());
            updateNegozio.get().setPartita_iva_negozio(negozio.getPartita_iva_negozio());
            updateNegozio.get().setCataloghi(negozio.getCataloghi());
            updateNegozio.get().setRecordStatusEnum(negozio.getRecordStatusEnum());
            Negozio negozioUpdate = negozioRepository.save(updateNegozio.get());
            return Optional.of(negozioUpdate);
        }
        return Optional.empty();
    }

    /**
     *
     * @param id per cercare il negozio da eliminare
     * @return mostra il negozio eliminata o un oggetto vuoto se non esiste
     */
    public Optional<Negozio> deleteNegozio (Long id ){
        Optional <Negozio> deleteNegozio = negozioRepository.findById(id);
        if (deleteNegozio.isPresent()){
            negozioRepository.delete(deleteNegozio.get());
        }else {
            return Optional.empty();
        }
        return deleteNegozio;
    }
}
