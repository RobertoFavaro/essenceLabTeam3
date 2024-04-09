package com.team3.essence.lavib.essence_lab.services;

import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
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
     * @param negozio
     * @return Salva l'oggetto e lo ritorna;
     */
    public Negozio addNegozio(Negozio negozio) {
        return negozioRepository.save(negozio);
    }

    /**
     * @return mostra la lista di tutti i negozi;
     */
    public List<Negozio> getAllNegozio() {
        return negozioRepository.findAllActiveNegozio();
    }

    /**
     * @param id
     * @return mostra i negozi cercata tramite id;
     */
    public Optional<Negozio> getNegozioId(Long id) {
        return negozioRepository.findById(id);
    }

    /**
     * @param id      per cercare il negozio da aggiornare
     * @param negozio
     * @return mostra il negozio aggiornata o un oggetto vuoto se non è presente
     */
    public Optional<Negozio> updateNegozio(Long id, Negozio negozio) {
        Optional<Negozio> updateNegozio = negozioRepository.findById(id);
        if (updateNegozio.isPresent()) {
            updateNegozio.get().setIndirizzo_negozio(negozio.getIndirizzo_negozio());
            updateNegozio.get().setNome_negozio(negozio.getNome_negozio());
            updateNegozio.get().setLuogo_negozio(negozio.getLuogo_negozio());
            updateNegozio.get().setPartita_iva_negozio(negozio.getPartita_iva_negozio());
            updateNegozio.get().setRecordStatusEnum(negozio.getRecordStatusEnum());
            Negozio negozioUpdate = negozioRepository.save(updateNegozio.get());
            return Optional.of(negozioUpdate);
        } else {
            return Optional.empty();
        }
    }

    /**
     *
     * @param id
     * @return il recordStatusEnum diventa inattivo
     */
    public Optional<Negozio> deactivateNegozioById(Long id) {
        Optional<Negozio> negozioOptional = negozioRepository.findById(id);
        if (negozioOptional.isPresent()) {
            negozioOptional.get().setRecordStatusEnum(RecordStatusEnum.I);
        } else {
            return Optional.empty();
        }
        return negozioOptional;
    }
    /**
     *
     * @param id
     * @return il recordStatusEnum diventa attivo
     */
    public Optional<Negozio> activeNegozioById(Long id) {
        Optional<Negozio> negozioOptional = negozioRepository.findById(id);
        if (negozioOptional.isPresent()) {
            negozioOptional.get().setRecordStatusEnum(RecordStatusEnum.A);
        } else {
            return Optional.empty();
        }
        return negozioOptional;
    }
    /**
     *
     * @return
     */
    public Optional<List<Negozio>> getByRecordStatusInactive(){
        Optional<List<Negozio>> listNegozi = Optional.ofNullable(negozioRepository.findByRecordStatusEnum(RecordStatusEnum.I));
        return listNegozi;
    }
}

//______________________(old method getByRecordStatusActive)__________________________________
///**
// * @return
// */
//public Optional<List<Negozio>> getByRecordStatusActive() {
//    Optional<List<Negozio>> listNegozi = Optional.ofNullable(negozioRepository.findByRecordStatus(RecordStatusEnum.A));
//    return listNegozi;
//}


//______________________(old method deleteNegozio)_____________________
// **
//* @param id per cercare il negozio da eliminare
//* @return mostra il negozio eliminata o un oggetto vuoto se non esiste
//*/
//ublic Optional<Negozio> deleteNegozio(Long id) {
//   Optional<Negozio> deleteNegozio = negozioRepository.findById(id);
//   if (deleteNegozio.isPresent()) {
//       negozioRepository.delete(deleteNegozio.get());
//   } else {
//       return Optional.empty();
//   }
//   return deleteNegozio;