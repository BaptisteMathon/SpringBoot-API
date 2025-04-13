package com.api_etudiant.example.demo.entity;

public class Rapport {
    private double moyenne;

    public Rapport() {}

    public Rapport(double moyenne) {
        this.moyenne = moyenne;
    }

    public double getMoyenne() {
        return moyenne;
    }
    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }
}
