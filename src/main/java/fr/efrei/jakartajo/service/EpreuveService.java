package fr.efrei.jakartajo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.efrei.jakartajo.model.Epreuve;
import fr.efrei.jakartajo.model.Utilisateur;
import fr.efrei.jakartajo.repository.EpreuveRepository;
import jakarta.transaction.Transactional;

@Service
public class EpreuveService {
    private final EpreuveRepository repository;
    private final UtilisateurService utilisateurService;

    @Autowired
    public EpreuveService(EpreuveRepository repository, UtilisateurService utilisateurService) {
        this.repository = repository;
        this.utilisateurService = utilisateurService;
    }

    public List<Epreuve> findAll() {
        return repository.findAll();
    }

    public Epreuve save(Epreuve epreuve) {
        return repository.save(epreuve);
    }

    @Transactional
    public Epreuve ajoutEtudiant(String epreuveId, String utilisateurId) {
        Epreuve epreuve = repository.findById(epreuveId).orElse(null);
        Utilisateur utilisateur = utilisateurService.findUtilisateurById(utilisateurId);
        epreuve.getUtilisateurs().add(utilisateur);
        repository.save(epreuve);
        return epreuve;
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
