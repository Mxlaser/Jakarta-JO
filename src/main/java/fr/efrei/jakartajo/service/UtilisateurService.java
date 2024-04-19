package fr.efrei.jakartajo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.efrei.jakartajo.dto.CreateUtilisateur;
import fr.efrei.jakartajo.dto.UpdateUtilisateur;
import fr.efrei.jakartajo.model.Utilisateur;
import fr.efrei.jakartajo.repository.UtilisateurRepository;
import jakarta.transaction.Transactional;

@Service
public class UtilisateurService {

	private final UtilisateurRepository repository;

	@Autowired
	public UtilisateurService(UtilisateurRepository repository) {
		this.repository = repository;
	}

	public List<Utilisateur> findAllUtilisateurs() {
		return repository.findAllByDeletedAtNull();
	}

	public Utilisateur findUtilisateurById(String id) {
		return repository.findOneById(id).orElse(null);
	}

    public Utilisateur create(CreateUtilisateur utilisateur) {
		Utilisateur utilisateurACreer = new Utilisateur(
				utilisateur.getNom(),
			    utilisateur.getPrenom()
		);
		return repository.save(utilisateurACreer);
	}

	@Transactional
	public boolean delete(String id) {
		Utilisateur utilisateurASupprimer = findUtilisateurById(id);
		if(utilisateurASupprimer != null && utilisateurASupprimer.getDeletedAt() == null) {
			utilisateurASupprimer.setDeletedAt(LocalDateTime.now());
			repository.save(utilisateurASupprimer);
			return true;
		}
		return false;
	}

	public boolean update(String id, UpdateUtilisateur utilisateur) {
		Utilisateur utilisateurAModifier = findUtilisateurById(id);

		if(utilisateurAModifier != null) {
			utilisateurAModifier.setPrenom(utilisateur.getPrenom());
			utilisateurAModifier.setNom(utilisateur.getNom());
			repository.save(utilisateurAModifier);
			return true;
		}
		return false;
	}

	public boolean updatePartielle(String id, UpdateUtilisateur utilisateur) {
		Utilisateur utilisateurAModifier = findUtilisateurById(id);

		if(utilisateurAModifier != null) {
			if(!utilisateur.getPrenom().isEmpty()) {
				utilisateurAModifier.setPrenom(utilisateur.getPrenom());
			}
			if(!utilisateur.getNom().isEmpty()) {
				utilisateurAModifier.setNom(utilisateur.getNom());
			}
			repository.save(utilisateurAModifier);
			return true;
		}
		return false;
	}
}