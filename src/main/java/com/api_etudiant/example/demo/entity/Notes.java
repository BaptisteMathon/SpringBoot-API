package com.api_etudiant.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Notes")
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "Cours")
    private Cours cours;

    @NotNull(message = "Veuillez insérer une note")
    @Column(name = "note")
    private double note;

    public Notes() {}

    public Notes(Student student, Cours cours, double note) {
        this.student = student;
        this.cours = cours;
        this.note = note;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Cours getCours() {
        return cours;
    }
    public void setCours(Cours cours) {
        this.cours = cours;
    }
    public double getNote() {
        return note;
    }
    public void setNote(double note) {
        this.note = note;
    }
}
