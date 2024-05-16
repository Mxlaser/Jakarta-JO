package fr.efrei.jakartajo.model;

import jakarta.persistence.*;

@Entity
    public class Stade {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    private String name;
    private String adresse;

    public Stade(){

    }

    public Stade(String name, String adresse){
        this.name = name;
        this.adresse = adresse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getUuid() {
        return uuid;
    }
}

