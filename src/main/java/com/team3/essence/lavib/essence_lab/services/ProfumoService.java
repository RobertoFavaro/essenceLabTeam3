package com.team3.essence.lavib.essence_lab.services;

import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import com.team3.essence.lavib.essence_lab.entities.Profumo;
import com.team3.essence.lavib.essence_lab.repositories.ProfumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfumoService {
    @Autowired
    private ProfumoRepository profumoRepository;

    /**
     * @param profumo
     * @return Salva l'oggetto e lo ritorna;
     */
    public Profumo addProfumo(Profumo profumo) {
        return profumoRepository.save(profumo);
    }

    /**
     * @return Ritorna la lista dei profumi;
     */
    public List<Profumo> getAllProfumi() {
        return profumoRepository.findAllActiveProfumi();
    }

    /**
     * @param id
     * @return Ritorna il profumo cercato tramite id;
     */
    public Optional<Profumo> getProfumoId(Long id) {
        return profumoRepository.findById(id);
    }

    /**
     * @param id              per cercare il profumo da aggiornare
     * @param profumoToUpdate
     * @return Profumo aggiornata o un oggetto vuoto se non è presente
     */
    public Optional<Profumo> updateProfumoId(Long id, Profumo profumoToUpdate) {
        Optional<Profumo> profumoUpdate = profumoRepository.findById(id);
        if (profumoUpdate.isPresent()) {
            profumoUpdate.get().setAllergeni_profumo(profumoToUpdate.getAllergeni_profumo());
            profumoUpdate.get().setDescrizione_profumo(profumoToUpdate.getDescrizione_profumo());
            profumoUpdate.get().setIngredienti_profumo(profumoToUpdate.getIngredienti_profumo());
            profumoUpdate.get().setNome_profumo(profumoToUpdate.getNome_profumo());
            profumoUpdate.get().setPrezzo_profumo(profumoToUpdate.getPrezzo_profumo());
            profumoUpdate.get().setEnumMarcaProfumo(profumoToUpdate.getEnumMarcaProfumo());
            profumoUpdate.get().setEnumTipoProfumo(profumoToUpdate.getEnumTipoProfumo());
            profumoUpdate.get().setEssenze(profumoToUpdate.getEssenze());
            Profumo profumoUpdated = profumoRepository.save(profumoUpdate.get());
            return Optional.of(profumoUpdated);
        } else {
            return Optional.empty();
        }
    }

    /**
     * @param id
     * @return il recordStatusEnum diventa inattivo
     */
    public Optional<Profumo> deactiveProfumoById(Long id) {
        Optional<Profumo> profumoOptional = profumoRepository.findById(id);
        if (profumoOptional.isPresent()) {
            profumoOptional.get().setRecordStatusEnum(RecordStatusEnum.I);
        } else {
            return Optional.empty();
        }
        return profumoOptional;
    }

    /**
     * @param id
     * @return il recordStatusEnum diventa attivo
     */

    public Optional<Profumo> activeProfumopById(Long id) {
        Optional<Profumo> profumoOptional = profumoRepository.findById(id);
        if (profumoOptional.isPresent()) {
            profumoOptional.get().setRecordStatusEnum(RecordStatusEnum.A);
        } else {
            return Optional.empty();
        }
        return profumoOptional;
    }

    /**
     * @return lista profumi con recordstatus attivo
     */
    public Optional<List<Profumo>> getByRecordStatusActive() {
        Optional<List<Profumo>> listaProfumi = Optional.ofNullable(profumoRepository.findByRecordStatusEnum(RecordStatusEnum.A));
        return listaProfumi;
    }

    /**
     * @return tutti i profumi inattivi
     */
    public Optional<List<Profumo>> getByRecordStatusInactive() {
        Optional<List<Profumo>> listProfumi = Optional.ofNullable(profumoRepository.findByRecordStatusEnum(RecordStatusEnum.I));
        return listProfumi;
    }
}
