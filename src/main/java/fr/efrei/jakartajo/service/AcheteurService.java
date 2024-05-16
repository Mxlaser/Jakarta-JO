package fr.efrei.jakartajo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.efrei.jakartajo.model.Acheteur;
import fr.efrei.jakartajo.repository.AcheteurRepository;

@Service
public class AcheteurService {
    private final AcheteurRepository repository;

    @Autowired
    public AcheteurService(AcheteurRepository repository) {
        this.repository = repository;
    }

    public List<Acheteur> findAcheteurs() {
        System.out.println("Trouvé");
        return repository.findAll();
    }

    public Acheteur findAcheteurById(string uuid) {
        return repository.findOneByUuid(uuid).orElse(null);
    }
}
