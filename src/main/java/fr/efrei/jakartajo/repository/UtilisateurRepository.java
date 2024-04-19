package fr.efrei.jakartajo.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import fr.efrei.jakartajo.model.Utilisateur;

@Repository
public interface UtilisateurRepository {

    List<Utilisateur> findAllByDeletedAtNull();
    Optional<Utilisateur> findOneById(String id);
    Utilisateur save(Utilisateur utilisateur);

    void deleteById(String id);
}
