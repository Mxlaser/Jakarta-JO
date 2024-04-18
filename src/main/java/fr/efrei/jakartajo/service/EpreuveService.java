package fr.efrei.jakartajo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.efrei.jakartajo.model.Utilisateur;

@Service
public class EpreuveService {
    private final EpreuveRepository repository;
    private final UtilisateurService utilisateurService;

    @Autowired
    public EpreuveService(EpreuveRepository repository, UtilisateurService utilisateurService) {
        this.repository = repository;
        this.utilisateurService = utilisateurService;
    }
}
