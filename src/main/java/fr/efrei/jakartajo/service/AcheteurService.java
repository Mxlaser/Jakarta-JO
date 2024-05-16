package fr.efrei.jakartajo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.efrei.jakartajo.model.Acheteur;
import fr.efrei.jakartajo.repository.AcheteurRepository;
import jakarta.transaction.Transactional;

@Service
public class AcheteurService {
    private final AcheteurRepository repository;

    @Autowired
    public AcheteurService(AcheteurRepository repository) {
        this.repository = repository;
    }

    public List<Acheteur> findAllAcheteurs() {
        return repository.findAllByDeletedAtNull();
    }

    public Acheteur findAcheteurById(String uuid) {
        return repository.findOneByUuid(uuid).orElse(null);
    }

    public Acheteur create(Acheteur acheteur) {
        Acheteur acheteurACreer = new Acheteur(
                acheteur.getName(),
                acheteur.getFirstName());
        return repository.save(acheteurACreer);
    }

    @Transactional
    public boolean delete(String uuid) {
        Acheteur acheteurASupprimer = findAcheteurById(uuid);
        if (acheteurASupprimer != null && acheteurASupprimer.getDeletedAt() == null) {
            acheteurASupprimer.setDeletedAt(LocalDateTime.now());
            repository.save(acheteurASupprimer);
            return true;
        }
        return false;
    }
}
