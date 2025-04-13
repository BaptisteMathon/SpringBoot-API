package com.api_etudiant.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "cours")
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Veuillez insérer un nom de cours")
    @Column(name = "nameCours")
    private String nameCours;

    @NotBlank(message = "Veuillez insérer un nom de professeur")
    @Column(name = "nameProf")
    private String nameProf;

    public Cours() {}

    public Cours(String nameCours, String nameProf){
        this.nameCours = nameCours;
        this.nameProf = nameProf;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNameCours() {
        return nameCours;
    }
    public void setNameCours(String nameCours) {
        this.nameCours = nameCours;
    }
    public String getNameProf() {
        return nameProf;
    }
    public void setNameProf(String nameProf) {
        this.nameProf = nameProf;
    }
}
