package com.team3.essence.lavib.essence_lab.services;

import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import com.team3.essence.lavib.essence_lab.entities.Cliente;
import com.team3.essence.lavib.essence_lab.entities.Essenza;
import com.team3.essence.lavib.essence_lab.repositories.EssenzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EssenzaService {
    @Autowired
    private EssenzaRepository essenzaRepository;

    /**
     *
     * @param essenza
     * @return Salva l'oggetto e lo ritorna;
     */
    public Essenza addEssenza(Essenza essenza){
        return essenzaRepository.save(essenza);
    }

    /**
     *
     * @return Ritorna la lista delle essenze;
     */
    public List<Essenza> getAllEssenze(){
        return essenzaRepository.findAll();
    }

    /**
     *
     * @param id
     * @return Ritorna l'essenza cercata tramite id;
     */
    public Optional<Essenza> getEssenzaId(Long id){
        return essenzaRepository.findById(id);
    }

    /**
     *
     * @param id per cercare l'essenza da aggiornare
     * @param essenza
     * @return L'essenza aggiornata o un oggetto vuoto se non è presente
     */
    public Optional<Essenza> updateEssenzaId(Long id,Essenza essenza){
        Optional<Essenza> updateEssenza = essenzaRepository.findById(id);
        if(updateEssenza.isPresent()){
            updateEssenza.get().setAllergeni_essenza(essenza.getAllergeni_essenza());
            updateEssenza.get().setDescrizione_essenza(essenza.getDescrizione_essenza());
            updateEssenza.get().setNome_essenza(essenza.getNome_essenza());
            updateEssenza.get().setIngredienti_essenza(essenza.getIngredienti_essenza());
            Essenza essenzaUpdate = essenzaRepository.save(updateEssenza.get());
            return Optional.of(essenzaUpdate);
        }else{
            return Optional.empty();
        }
    }
    /**
     *
     * @param id
     * @return il recordStatusEnum diventa inattivo
     */
    public Optional<Essenza> deactiveEssenzaById(Long id) {
        Optional<Essenza> essenzaOptional = essenzaRepository.findById(id);
        if (essenzaOptional.isPresent()) {
            essenzaOptional.get().setRecordStatusEnum(RecordStatusEnum.I);
        } else {
            return Optional.empty();
        }
        return essenzaOptional;
    }

    /**
     *
     * @param id
     * @return il recordStatusEnum diventa attivo
     */
    public Optional<Essenza> activeEssenzaById(Long id) {
        Optional<Essenza> essenzaOptional = essenzaRepository.findById(id);
        if (essenzaOptional.isPresent()) {
            essenzaOptional.get().setRecordStatusEnum(RecordStatusEnum.A);
        } else {
            return Optional.empty();
        }
        return essenzaOptional;
    }

    /**
     *
     * @return tutte le essenze inattive
     */
    public Optional<List<Essenza>> getByRecordStatusInactive(){
        Optional<List<Essenza>> listEssenze = Optional.ofNullable(essenzaRepository.findByRecordStatus(RecordStatusEnum.I));
        return listEssenze;
    }

}
