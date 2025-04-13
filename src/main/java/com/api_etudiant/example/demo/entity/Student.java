package com.api_etudiant.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Veuillez insérer un prénom")
    @Column(name = "prenom")
    private String prenom;

    @NotBlank(message = "Veuillez insérer un nom")
    @Column(name = "nom")
    private String nom;

    @Email(message = "Veuillez insérer un email valide")
    @NotBlank(message = "Veuillez insérer un email")
    @Column(name = "email")
    private String email;

    // @NotBlank(message = "Veuillez insérer un age")
    @Min(value = 0, message = "L'âge doit être supérieur ou égal à 0")
    @Column(name = "age")
    private Integer age;

    public Student() {}

    public Student (String prenom, String nom, String email, Integer age) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.age = age;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
}