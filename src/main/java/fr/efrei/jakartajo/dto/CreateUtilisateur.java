package fr.efrei.jakartajo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUtilisateur {

    @NotBlank
    @Size(min = 1, max = 25)
    private String nom;

    @NotBlank
    private String prenom;

    public CreateUtilisateur(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
    }
    public String getNom(){
        return nom;
    }
    public String getPrenom(){
        return prenom;
    }

}
