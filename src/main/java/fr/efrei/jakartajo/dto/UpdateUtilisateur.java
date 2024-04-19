package fr.efrei.jakartajo.dto;

public class UpdateUtilisateur {

    private String nom;

    private String prenom;

    public UpdateUtilisateur(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
    }
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}


}
