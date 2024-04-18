package fr.efrei.jakartajo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.cglib.core.Local;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private String id;

    private String nom;

    private String prenom;

    private LocalDateTime deleteAt= null;

    public Utilisateur(){}
    public Utilisateur(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getId(){
        return id;
    }
    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getPrenom(){
        return prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public LocalDateTime getDeleteAt(){
        return deleteAt;
    }
    public void setDeleteAt(LocalDateTime deleteAt){
        this.deleteAt = deleteAt;
    }
}
