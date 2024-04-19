package fr.efrei.jakartajo.model;

import jakarta.persistence.*;

@Entity
public class Acheteur {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    private String name;
    private String firstName;

    public Acheteur() {
    }

    public Acheteur(String name, String firstName) {
        this.name = name;
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUuid() {
        return uuid;
    }
}
