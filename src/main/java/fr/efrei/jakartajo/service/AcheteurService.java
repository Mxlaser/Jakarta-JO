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
        System.out.println("Trouvé");
        return repository.findAll();
    }

    public Acheteur findAcheteurById(String uuid) {
        return repository.findOneByUuid(uuid).orElse(null);
    }

    public Acheteur create(Acheteur acheteur) {
        return repository.save(acheteur);
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
