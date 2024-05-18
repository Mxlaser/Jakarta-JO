package fr.efrei.jakartajo.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Epreuve {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    private String name;
    private LocalDateTime dateEpreuve = null;
    private LocalDateTime deletedAt = null;

    public Epreuve(){

    }

    public Epreuve(String name, LocalDateTime dateEpreuve){
        this.name = name;
        this.dateEpreuve = dateEpreuve;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public LocalDateTime getDateEpreuve() {
        return dateEpreuve;
    }

    public void setDateEpreuve(LocalDateTime dateEpreuve) {
        this.dateEpreuve = dateEpreuve;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
