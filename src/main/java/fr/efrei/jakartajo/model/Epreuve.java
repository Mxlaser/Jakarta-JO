package fr.efrei.jakartajo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Epreuve {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private String nom;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "epreuve_id")
    private List<Utilisateur> utilisateurs = new ArrayList<>();

    public String getNom() {
        return nom;
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public String getUuid() {
        return uuid;
    }
}
